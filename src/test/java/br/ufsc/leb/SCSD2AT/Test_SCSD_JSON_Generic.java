package br.ufsc.leb.SCSD2AT;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Test_SCSD_JSON_Generic extends TestCase {

	
    public Test_SCSD_JSON_Generic ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( Test_SCSD_JSON_Generic.class );
    }

 

	// GENERATE TEMPLATES
	
	public void test_generateAcceptanceTestsTemplate() {
		SCSD scsd = new SCSD_JSON("SC-Generic");
		ATTemplateGenerator generator = new ATTemplateGenerator(scsd);
		generator.generateATTemplates();
	}
	
}




