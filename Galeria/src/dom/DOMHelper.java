package dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author Apolinar T
 */
public class DOMHelper {

    public static Document getDocument(String ruta) {
        Document d = null;
        try {
            DocumentBuilderFactory dbf = 
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            d = db.parse(ruta);
        } catch (Exception e) {
            d = null;
        }
        return d;
    }

    public static String getXMLContent(Document d) {
        String resultado = "";
        try {
            TransformerFactory tff = 
                    TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource source = new DOMSource(d);
            tf.transform(source, sr);
            resultado = sw.toString();
        } catch (Exception e) {
            resultado = "";
        }
        return resultado;
    }

    public static void saveXMLContent(Document d, String ruta) {
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource ds = new DOMSource(d);
            StreamResult sr = new StreamResult(ruta);
            tf.transform(ds, sr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void FileCopy(String sourceFile, String destinationFile) {
        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);
            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Error de entrada/salida");
        }
    }
}
