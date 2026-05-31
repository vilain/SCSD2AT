package scsd2at;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import scsd2at.ATTemplateGenerator;
import scsd2at.SCSD;
import scsd2at.SCSD_JSON;


public class TestSCSD_JSON_Contract extends TestCase {

	
    public TestSCSD_JSON_Contract ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( TestSCSD_JSON_Contract.class );
    }

	public void test_generateAcceptanceTestsTemplate() {
		SCSD SCSDFarmRent = new SCSD_JSON("SC-Farm-Rent");
		ATTemplateGenerator generator = new ATTemplateGenerator(SCSDFarmRent);
		generator.generateATTemplates();
	}
	
}
