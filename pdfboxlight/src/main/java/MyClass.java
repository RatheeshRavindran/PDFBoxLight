import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccess;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.NonSequentialPDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class MyClass {
	public static void main(String[] args) throws IOException {
		PDDocument doc = null;
		try {
			System.out.println("1");
			// //doc = PDDocument.load(
			// "D:\\KnowledgeBase\\Books\\GoogleSecrets_TipsTricks.pdf" );
			// doc = PDDocument.load(
			// "D:\\KnowledgeBase\\Books\\Manning.Test.Driven.TDD.and.Acceptance.TDD.for.Java.Developers.Oct.2007.pdf");
			// System.out.println("2");
			// System.out.println(doc.getNumberOfPages());
			// PDFTextStripper textStripper = new PDFTextStripper();
			// textStripper.setStartPage(4);
			// textStripper.setEndPage(4);
			// String data = textStripper.getText(doc);
			// System.out.println("3");
			// System.out.println(data);
			// textStripper.setStartPage(2);
			// textStripper.setEndPage(2);
			// data = textStripper.getText(doc);
			// System.out.println("4");
			// System.out.println(data);

			// TemporaryResources tmp = new TemporaryResources();
			// File tempFile = new File("scratchfile");
			// File pdfFile = new
			// File("D:\\KnowledgeBase\\Books\\Manning.Test.Driven.TDD.and.Acceptance.TDD.for.Java.Developers.Oct.2007.pdf");
			// tempFile.createNewFile();
			// RandomAccess scratchFile = new RandomAccessFile(tempFile, "rw");
			// doc = PDDocument.loadNonSeq(pdfFile, scratchFile);
			// PDFTextStripper textStripper = new PDFTextStripper();
			// System.out.println("Used Memory: " +
			// (Runtime.getRuntime().totalMemory() -
			// Runtime.getRuntime().freeMemory()));
			// for (int page=550; page <551; page++) {
			// textStripper.setStartPage(page);
			// textStripper.setEndPage(page);
			// String data = textStripper.getText(doc);
			// System.out.println("3 " + "pageNum " + page);
			// System.out.println(data);
			// }
			// System.out.println("Used Memory: " +
			// (Runtime.getRuntime().totalMemory() -
			// Runtime.getRuntime().freeMemory()));

			File tempFile = new File("scratchfile");
//			File pdfFile = new File(
//					"D:\\KnowledgeBase\\Books\\Manning.Test.Driven.TDD.and.Acceptance.TDD.for.Java.Developers.Oct.2007.pdf");
//			File pdfFile = new File(
//			"D:\\KnowledgeBase\\Books\\physicsforentert035428mbp.pdf");
			File pdfFile = new File(
			"D:\\userdata\\raravind\\Desktop\\Croatian_Bible_40__Matthew.pdf");
			if(tempFile.exists()) {
				tempFile.delete();
			}
			tempFile.createNewFile();
//			TemporaryResources tmp = new TemporaryResources();
			RandomAccess scratchFile = new RandomAccessFile(
					tempFile/*tmp.createTemporaryFile()*/, "rw");
			NonSequentialPDFParser parser = new NonSequentialPDFParser(pdfFile/*file*/, scratchFile);
			parser.parse();
			COSDocument cosDoc = parser.getDocument();
			PDFTextStripper pdfStripper = new PDFTextStripper();
			PDDocument pdDoc = new PDDocument(cosDoc);
			pdfStripper.setStartPage(11);
			pdfStripper.setEndPage(11);
			System.out.println("Used Memory: "
					+ (Runtime.getRuntime().totalMemory() - Runtime
							.getRuntime().freeMemory()));
			   FileWriter fw = new FileWriter(new File("extractedcontent.txt"));
//			String parsedText = pdfStripper.getText(pdDoc, fw);
//			System.out.println("text " + parsedText);
			   pdfStripper.writeText(pdDoc, fw);
				pdDoc.close();
				fw.close();
		} finally {
			if (doc != null) {
				doc.close();
			}
		}

	}
}
