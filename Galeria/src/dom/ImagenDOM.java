/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import clases.Imagen;
import clases.ListaImagenes;
import clases.NodoD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author gerardo
 */
public class ImagenDOM {

    private String pathFile = getClass().getResource("/datos/datosI.xml").toString();

    public void addAll(ListaImagenes lista, String pathFile2) {
        Imagen imagen;
        NodoD nodo;

        try {
            Document d = DOMHelper.getDocument(pathFile);
            Element imagenes = d.getDocumentElement();
            lista.irPrimero();
            nodo = lista.getActual();
            while (nodo != null) {
                imagen = nodo.getDatos();

                Element item = d.createElement("imagen");

                Element id = d.createElement("id");
                id.appendChild(d.createTextNode("" + imagen.getId()));
                item.appendChild(id);

                Element titulo = d.createElement("titulo");
                titulo.appendChild(d.createTextNode(imagen.getTitulo()));
                item.appendChild(titulo);

                

                Element ruta = d.createElement("ruta");
                ruta.appendChild(d.createTextNode(imagen.getRuta()));
                item.appendChild(ruta);

                imagenes.appendChild(item);

                nodo = nodo.getSig();
            } // fin del while

            DOMHelper.saveXMLContent(d, pathFile2);
        } catch (Exception e) {
            System.err.println("fallo algo");

        }
    }

    public List<Imagen> getAll(String pathFile2) {

        List<Imagen> imagenes = new ArrayList();
        Imagen imagen;

        try {

            Document document = DOMHelper.getDocument(pathFile2);
            NodeList nodelist = document.getElementsByTagName("imagen");
            for (int i = 0; i < nodelist.getLength(); i++) {

                Element s = (Element) nodelist.item(i);
                imagen = new Imagen();

                imagen.setId(Integer.parseInt(s.getElementsByTagName("id").item(0).getTextContent()));
                imagen.setTitulo(s.getElementsByTagName("titulo").item(0).getTextContent());
               
                imagen.setRuta(s.getElementsByTagName("ruta").item(0).getTextContent());

                imagenes.add(imagen);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }

        return imagenes;

    }
}
