package br.ufsc.leb.SCSD2AT;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestSCSD_JSON_Paper_Sale_UFSC extends TestCase {

	
    public TestSCSD_JSON_Paper_Sale_UFSC ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( TestSCSD_JSON_Paper_Sale_UFSC.class );
    }

	public void test_generateAcceptanceTestsTemplate() {
		SCSD SCSDPaperSale = new SCSD_JSON("SC-Paper-Sale-UFSC");
		ATTemplateGenerator generator = new ATTemplateGenerator(SCSDPaperSale);
		generator.generateATTemplates();
		
	}
	
}
