package converter;

import java.io.*;
import java.nio.charset.*;
import org.apache.commons.io.*;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class Convert {
	public static void main(String[] args) {
		String inputFileName = args[0];
		String outputFileName = args[1];
		// Based on: https://github.com/danfickle/openhtmltopdf/wiki/PDF-Accessibility-(PDF-UA,-WCAG,-Section-508)-Support#builder-example
		try (FileOutputStream os = new FileOutputStream(outputFileName)) {
			PdfRendererBuilder builder = new PdfRendererBuilder();
			builder.useFastMode(); // required
			builder.usePdfUaAccessbility(true); // required
			// Remember to add one or more fonts.
			builder.useFont(new File("fonts/OpenSans-Regular.ttf"), "OpenSans-Regular");
			builder.useFont(new File("fonts/OpenSans-SemiBold.ttf"), "OpenSans-SemiBold");
			builder.useFont(new File("fonts/OpenSans-Italic.ttf"), "OpenSans-Italic");
			File html = new File(inputFileName);
			String htmlContent = FileUtils.readFileToString(html, StandardCharsets.UTF_8);
			builder.withHtmlContent(htmlContent, "/");
			builder.toStream(os);
			builder.run();
		} catch(Exception error){
			System.err.println(error);
		}
	}
}
