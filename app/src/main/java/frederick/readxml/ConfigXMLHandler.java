package frederick.readxml;


import android.content.Context;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ConfigXMLHandler extends DefaultHandler {

    String empresaId;
    String empresaName;
    String empresaDescripcion;
    String empresaLocalizacion;
    ArrayList<Programador> listaProgramadores;
    Programador programador;
    Caracteristica caracteristica;
    String[] itemNames;

    boolean currentElement = false;
    String currentValue = "";


    public ConfigXMLHandler(Context context) {
        itemNames = context.getResources().getStringArray(R.array.xml_schema);
    }

    public String getEmpresaId() {
        return empresaId;
    }

    public String getEmpresaName() {
        return empresaName;
    }

    public String getEmpresaDescripcion() {
        return empresaDescripcion;
    }

    public String getEmpresaLocalizacion() {
        return empresaLocalizacion;
    }

    public ArrayList<Programador> getListaProgramadores() {
        return listaProgramadores;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = true;
        currentValue = "";

        if (qName.equals("data")){}

        else if (qName.equals("programadores")) {
            listaProgramadores = new ArrayList<Programador>();
        }

        else if (qName.equals("programador")) {
            programador = new Programador();
        }

        else if (qName.equals("caracteristicas")) {
            caracteristica = new Caracteristica();
        }


    }


    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("empresaId"))                empresaId = currentValue.trim();
        else if (qName.equalsIgnoreCase("empresaName"))         empresaName = currentValue.trim();
        else if (qName.equalsIgnoreCase("empresaDescripcion"))  empresaDescripcion = currentValue.trim();
        else if (qName.equalsIgnoreCase("empresaLocalizacion")) empresaLocalizacion = currentValue.trim();
//personal
        else if (qName.equalsIgnoreCase("nombre"))      programador.setNombre(currentValue.trim());
        else if (qName.equalsIgnoreCase("apellido"))    programador.setApellido(currentValue.trim());
        else if (qName.equalsIgnoreCase("cedula"))      programador.setCedula(currentValue.trim());
        else if (qName.equalsIgnoreCase("cargo"))       programador.setCargo(currentValue.trim());
        else if (qName.equalsIgnoreCase("programador")) listaProgramadores.add(programador);
//caracteristicas
        else if (qName.equalsIgnoreCase("caracteristicaI"))     caracteristica.setCaract1(currentValue.trim());
        else if (qName.equalsIgnoreCase("caracteristicaII"))    caracteristica.setCaract2(currentValue.trim());
        else if (qName.equalsIgnoreCase("caracteristicaIII"))   caracteristica.setCaract3(currentValue.trim());

        currentValue = "";
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }

    }


}
