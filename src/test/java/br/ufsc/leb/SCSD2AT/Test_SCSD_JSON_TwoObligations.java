package br.ufsc.leb.SCSD2AT;

import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Test_SCSD_JSON_TwoObligations extends TestCase {

	
    public Test_SCSD_JSON_TwoObligations ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( Test_SCSD_JSON_TwoObligations.class );
    }

    //SC_Two_Obligations - Creation
    
	public void test_getName_SC_Two_Obligations() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		assertEquals ("SC-Two-Obligations", SCSDWithTwoObligations.getName());
	}
	
 	public void test_hasCreatedState_SC_Two_Obligations() {
		SCSD scsd = new SCSD_JSON("SC-Two-Obligations");
		assertTrue (scsd.hasCreatedState());
	}

 	public void test_hasSuspendedState_SC_Two_Obligations() {
		SCSD scsd = new SCSD_JSON("SC-Two-Obligations");
		assertTrue (scsd.hasSuspendedState());
	}

 	public void test_getObligationsActivatedInTransitionFromCreatedToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listObligations = SCSDWithTwoObligations.getObligationsActivated();
		assertEquals (2, listObligations.size());
		assertEquals ("obligation 1", listObligations.get(0));	
		assertEquals ("obligation 2", listObligations.get(1));	
	}
	
	public void test_getPowersActivatedInTransitionFromCreatedToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listPowers = SCSDWithTwoObligations.getPowersActivated();
		assertEquals (2, listPowers.size());
		assertEquals ("power 1", listPowers.get(0));	
		assertEquals ("power 3", listPowers.get(1));	
	}

	
    //SC_Two_Obligations - Activation of obligations and powers
	
	public void test_getListOfObligationsToBeActivatedLaterInTransitionFromInEffectToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List listOfListObligations = SCSDWithTwoObligations.getObligationsToBeActivatedLater();
		assertEquals (2, listOfListObligations.size());
		assertEquals ("obligation 20", ((List)listOfListObligations.get(0)).get(0));	
		assertEquals ("power 1", ((List)listOfListObligations.get(0)).get(1));	
		assertEquals ("obligation 30", ((List)listOfListObligations.get(1)).get(0));	
		assertEquals ("power 1", ((List)listOfListObligations.get(1)).get(1));	
	}

	public void test_getListOfPowersToBeActivatedLaterInTransitionFromInEffectToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List listOfListPowers = SCSDWithTwoObligations.getPowersToBeActivatedLater();
		assertEquals (2, listOfListPowers.size());
		assertEquals ("power 10", ((List)listOfListPowers.get(0)).get(0));	
		assertEquals ("power 1", ((List)listOfListPowers.get(0)).get(1));	
		assertEquals ("power 20", ((List)listOfListPowers.get(1)).get(0));	
		assertEquals ("power 1", ((List)listOfListPowers.get(1)).get(1));	
	}

	
    //SC_Two_Obligations - Suspension and resume of the contract
	
	public void test_getPowersThatSuspendTheContractInSuspendContract_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listPowers = SCSDWithTwoObligations.getPowersThatSuspendTheContract();
		assertEquals (1, listPowers.size());
		assertEquals ("power 3", listPowers.get(0));
	}
	
	public void test_getPowersThatResumeTheContractInSuspendContract_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listPowers = SCSDWithTwoObligations.getPowersThatResumeTheContract();
		assertEquals (1, listPowers.size());
		assertEquals ("power 20", listPowers.get(0));
	}


    //SC_Two_Obligations - Parties
	
	public void test_getListOfPartiesOfTheContract() {
		SCSD scsd = new SCSD_JSON("SC-Two-Obligations");
		List listParties = scsd.getPartiesOfTheContract();
		assertEquals (2, listParties.size());
		assertEquals ("party 1", listParties.get(0));	
		assertEquals ("party 2", listParties.get(1));	
	}
	
	public void test_getPartiesAndTheirObligations() {
		SCSD scsd = new SCSD_JSON("SC-Two-Obligations");
		List listPartiesAndObligations = scsd.getPartiesAndTheirObligationsOfTheContract();
		assertEquals (2, listPartiesAndObligations.size());
		assertEquals ("party 1", ((List)listPartiesAndObligations.get(0)).get(0));	
		assertEquals ("obligation 1", ((List)listPartiesAndObligations.get(0)).get(1));	
		assertEquals ("party 2", ((List)listPartiesAndObligations.get(1)).get(0));	
		assertEquals ("obligation 2", ((List)listPartiesAndObligations.get(1)).get(1));	
	}
	
	public void test_getPartiesAndTheirPowers() {
		SCSD scsd = new SCSD_JSON("SC-Two-Obligations");
		List listPartiesAndPowers = scsd.getPartiesAndTheirPowersOfTheContract();
		assertEquals (2, listPartiesAndPowers.size());
		assertEquals ("party 1", ((List)listPartiesAndPowers.get(0)).get(0));	
		assertEquals ("power 1", ((List)listPartiesAndPowers.get(0)).get(1));	
		assertEquals ("party 2", ((List)listPartiesAndPowers.get(1)).get(0));	
		assertEquals ("power 3", ((List)listPartiesAndPowers.get(1)).get(1));	
	}	
		
	public void test_getPowerThatReplaceParties_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		String power = SCSDWithTwoObligations.getPowerThatReplaceParties();
		assertEquals ("power 1", power);	
	}


	// SUCCESSFUL TERMINATION
	
	public void test_getObligationsFulfilledInTransitionFromInEffectToSuccessfulTermination_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List listObligations = (List) SCSDWithTwoObligations.getObligationsFulfilled().get(0);
		assertEquals (2, listObligations.size());
		assertEquals ("obligation 1", listObligations.get(0));
		assertEquals ("obligation 2", listObligations.get(1));
	}

	public void test_getSurvivingObligationsInTransitionFromInEffectToSuccessfulTermination() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listSurvivingObligations = (List<String>) SCSDWithTwoObligations.getSurvivingObligations();
		assertEquals (2, listSurvivingObligations.size());
		assertEquals ("surviving obligation 1", listSurvivingObligations.get(0));
		assertEquals ("surviving obligation 2", listSurvivingObligations.get(1));
	}
	
	
	// UNSUCCESSFUL TERMINATION
	
	public void test_getObligationsAndPowersInTransitionFromInEffectToUnsuccessfulTermination_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listPowers = (List<String>) SCSDWithTwoObligations.getPowersUnfulfilled();
		assertEquals (1, listPowers.size());
		assertEquals ("~obligation 1 AND power 2", listPowers.get(0));
	}

	public void test_getPenaltiesUnfulfilledInTransitionFromInEffectToUnsuccessfulTermination() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		List<String> listPenalties = (List<String>) SCSDWithTwoObligations.getPenalties();
		assertTrue (listPenalties.isEmpty());
	}

	
	// GENERATE TEMPLATES
	
	public void test_generateAcceptanceTestsTemplate() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Two-Obligations");
		ATTemplateGenerator generator = new ATTemplateGenerator(SCSDWithTwoObligations);
		generator.generateATTemplates();
	}
	
}




