package br.edu.ifgoiano.farmacia.test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.SaidasMedicamento;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class TextRelatorios {

	@Test
	public void deveCriarRelatorioDeSaidasMedicamentos()
			throws FileNotFoundException, DocumentException {
		/*
		 * DAO<SaidasMedicamento> dao = new DAO<SaidasMedicamento>(
		 * SaidasMedicamento.class);
		 * 
		 * List<SaidasMedicamento> retrivetAll = dao.retrivetAll(); for
		 * (SaidasMedicamento saidasMedicamento : retrivetAll) {
		 * System.out.println(saidasMedicamento.toString()); }
		 */

		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream(
				"/home/pompeu/teste.pdf"));
		document.open();

		document.add(new Paragraph("Hello World! 2"));

		document.close();

	}
}
