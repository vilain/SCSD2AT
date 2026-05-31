package scsd2at;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import scsd2at.ATTemplateGenerator;
import scsd2at.SCSD;
import scsd2at.SCSD_JSON;


public class TestSCSD_JSON_Paper_Sale extends TestCase {

	
    public TestSCSD_JSON_Paper_Sale ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( TestSCSD_JSON_Paper_Sale.class );
    }

	public void test_generateAcceptanceTestsTemplate() {
		SCSD SCSDPaperSale = new SCSD_JSON("SC-Paper-Sale");
		ATTemplateGenerator generator = new ATTemplateGenerator(SCSDPaperSale);
		generator.generateATTemplates();
		
	}
	
}
