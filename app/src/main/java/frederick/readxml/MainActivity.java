package frederick.readxml;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConfigXMLHandler custom = parseXML();

        Log.i("INFO", custom.getEmpresaId());
        Log.i("INFO", custom.getEmpresaDescripcion());

        for(Programador p : custom.getListaProgramadores()){
            Log.i("Programadores",p.getNombre());
            Log.i("Programadores",p.getApellido());
        }

    }

    public ConfigXMLHandler parseXML() {
        try {
            InputStream is=getResources().openRawResource(R.raw.file);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            ConfigXMLHandler myXMLHandler = new ConfigXMLHandler(this);
            xr.setContentHandler(myXMLHandler);
            InputSource inStream = new InputSource(is);
            xr.parse(inStream);

            is.close();

            return myXMLHandler;

        } catch (Exception e) {
            Log.i("ERROR", "ERROR");
            e.printStackTrace();
            return null;
        }

    }

}
