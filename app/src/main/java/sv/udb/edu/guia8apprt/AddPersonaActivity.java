package sv.udb.edu.guia8apprt;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import sv.udb.edu.guia8apprt.datos.Persona;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre, edtBorn, edtPeso, edtAltura;
    RadioGroup rgSexo;
    RadioButton rbMan, rbWoman;
    DatePickerDialog picker;

    String key="",nombre="",dui="",accion="", nacimiento="", sexo="", peso="", altura="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();
    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtAltura = findViewById(R.id.editAltura);
        edtBorn = findViewById(R.id.edtBorn);
        edtPeso = findViewById(R.id.editPeso);
        rgSexo = findViewById(R.id.rgSexo);
        rbMan = findViewById(R.id.rbMan);
        rbWoman = findViewById(R.id.rbWomen);

        // crear picker
        edtBorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);
            }
        });
        edtBorn.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b == true) {
                    showDialog(view);
                }
            }
        });

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        accion=datos.getString("accion");
        nacimiento=datos.getString("born");
        altura=datos.getString("height");
        peso=datos.getString("weight");
        sexo=datos.getString("sex");

        if(key != "a") {
            edtDUI.setText(dui);
            edtNombre.setText(nombre);
            edtBorn.setText(nacimiento);
            edtPeso.setText(peso);
            edtAltura.setText(altura);
            if(sexo.equals("Hombre")) {
                rbMan.setChecked(true);
            } else if (sexo.equals("Mujer")){
                rbWoman.setChecked(true);
            }
        }
    }

    private void showDialog(View view) {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        // date picker dialog
        picker = new DatePickerDialog(AddPersonaActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edtBorn.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String born = edtBorn.getText().toString();
        int selected = rgSexo.getCheckedRadioButtonId();
        RadioButton rbSelected = findViewById(selected);
        String peso = edtPeso.getText().toString();
        String altura = edtAltura.getText().toString();
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre, born, rbSelected.getText().toString(), peso, altura);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }

    public void cancelar(View v){
        finish();
    }


}
