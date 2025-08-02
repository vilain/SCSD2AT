package br.ufsc.leb.SCSD2AT;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TestSCSD_JSON_UFSC_Contract extends TestCase {

	
    public TestSCSD_JSON_UFSC_Contract ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( TestSCSD_JSON_UFSC_Contract.class );
    }

	public void test_generateAcceptanceTestsTemplate() {
		SCSD SCSDFarmRent = new SCSD_JSON("SC-Farm-Rent");
		ATTemplateGenerator generator = new ATTemplateGenerator(SCSDFarmRent);
		generator.generateATTemplates();
	}
	
}
