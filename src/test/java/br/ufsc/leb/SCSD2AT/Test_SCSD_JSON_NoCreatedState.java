package br.ufsc.leb.SCSD2AT;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Test_SCSD_JSON_NoCreatedState extends TestCase {

	
    public Test_SCSD_JSON_NoCreatedState ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( Test_SCSD_JSON_NoCreatedState.class );
    }

    //SC_Two_Obligations
    
	public void test_getName() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		assertEquals ("SC-No-Created-State", SCSDWithTwoObligations.getName());
	}
	
 	public void test_hasCreatedState() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		assertFalse (scsd.hasCreatedState());
	}

 	public void test_hasSuspendedState() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		assertFalse (scsd.hasSuspendedState());
	}

	public void test_getObligationsActivatedInTransitionFromInitialToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		List<String> listObligations = SCSDWithTwoObligations.getObligationsActivated();
		assertEquals (2, listObligations.size());
		assertEquals ("obligation 1", listObligations.get(0));	
		assertEquals ("obligation 2", listObligations.get(1));	
	}
	
	public void test_getObligationsCreatedInTransitionFromInitialToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		List<String> listObligations = SCSDWithTwoObligations.getObligationsCreated();
		assertEquals (2, listObligations.size());
		assertEquals ("obligation 1", listObligations.get(0));	
		assertEquals ("obligation 2", listObligations.get(1));	
	}
	
	public void test_getPowersActivatedInTransitionFromCreatedToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		List<String> listPowers = SCSDWithTwoObligations.getPowersActivated();
		assertEquals (2, listPowers.size());
		assertEquals ("power 1", listPowers.get(0));	
		assertEquals ("power 3", listPowers.get(1));	
	}

	public void test_getPowersCreatedInTransitionFromCreatedToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		List<String> listPowers = SCSDWithTwoObligations.getPowersCreated();
		assertEquals (2, listPowers.size());
		assertEquals ("power 1", listPowers.get(0));	
		assertEquals ("power 3", listPowers.get(1));	
	}

	public void test_getListOfObligationsToBeActivatedLaterInTransitionFromInEffectToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		List listOfListObligations = SCSDWithTwoObligations.getObligationsToBeActivatedLater();
		assertTrue (listOfListObligations.isEmpty());
	}
	

	public void test_getListOfPowersToBeActivatedLaterInTransitionFromInEffectToInEffect_SC_Two_Obligation() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		List listOfListPowers = SCSDWithTwoObligations.getPowersToBeActivatedLater();
		assertTrue (listOfListPowers.isEmpty());
	}
	
	
	// PARTIES
	
	public void test_getListOfPartiesOfTheContract() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List listParties = scsd.getPartiesOfTheContract();
		assertEquals (2, listParties.size());
		assertEquals ("party 1", listParties.get(0));	
		assertEquals ("party 2", listParties.get(1));	
	}
	
	public void test_getPartiesAndTheirObligations() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List listPartiesAndObligations = scsd.getPartiesAndTheirObligationsOfTheContract();
		assertEquals (2, listPartiesAndObligations.size());
		assertEquals ("party 1", ((List)listPartiesAndObligations.get(0)).get(0));	
		assertEquals ("obligation 1", ((List)listPartiesAndObligations.get(0)).get(1));	
		assertEquals ("party 2", ((List)listPartiesAndObligations.get(1)).get(0));	
		assertEquals ("obligation 2", ((List)listPartiesAndObligations.get(1)).get(1));	
	}
	
	public void test_getPartiesAndTheirPowers() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List listPartiesAndPowers = scsd.getPartiesAndTheirPowersOfTheContract();
		assertEquals (2, listPartiesAndPowers.size());
		assertEquals ("party 1", ((List)listPartiesAndPowers.get(0)).get(0));	
		assertEquals ("power 1", ((List)listPartiesAndPowers.get(0)).get(1));	
		assertEquals ("party 2", ((List)listPartiesAndPowers.get(1)).get(0));	
		assertEquals ("power 3", ((List)listPartiesAndPowers.get(1)).get(1));	
	}	
	
	public void test_getPowerThatReplacePartiesInTransitionFromActiveToActive() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		String power = scsd.getPowerThatReplaceParties();
		assertEquals ("", power);	
	}	
	
	public void test_getPartiesReplacedInTransitionFromActiveToActive() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List listOldPartyNewPartyObligation = scsd.getPartiesReplacedForObligations();
		assertTrue (listOldPartyNewPartyObligation.isEmpty());	
	}

	
	// SUCCESSFUL TERMINATION

	public void test_getObligationsFulfilledInTransitionFromInEffectToSuccessfulTermination_SC_Two_Obligation() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List listOfListsObligations = (List) scsd.getObligationsFulfilled();
		assertEquals (2, listOfListsObligations.size());
		assertEquals ("obligation 2", ((List)listOfListsObligations.get(0)).get(0));
		assertEquals ("obligation 1", ((List)listOfListsObligations.get(1)).get(0));
	}

	public void test_getSurvivingObligationsInTransitionFromInEffectToSuccessfulTermination() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List<String> listSurvivingObligations = (List<String>) scsd.getSurvivingObligations();
		assertEquals (1, listSurvivingObligations.size());
		assertEquals ("surviving obligation 1", listSurvivingObligations.get(0));
	}
	

	
	// UNSUCCESSFUL TERMINATION
	
	public void test_getObligationsAndPowersInTransitionFromInEffectToUnsuccessfulTermination_SC_Two_Obligation() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List<String> listPowers = (List<String>) scsd.getPowersUnfulfilled();
		assertEquals (1, listPowers.size());
		assertEquals ("~obligation 1 AND power 2", listPowers.get(0));
	}
		
	public void test_getPenaltiesUnfulfilledInTransitionFromInEffectToUnsuccessfulTermination() {
		SCSD scsd = new SCSD_JSON("SC-No-Created-State");
		List<String> listPenalties = (List<String>) scsd.getPenalties();
		assertEquals (2, listPenalties.size());
		assertEquals ("penalty 1", listPenalties.get(0));
		assertEquals ("penalty 2", listPenalties.get(1));
	}


	// GENERATE TEMPLATES
	
	public void test_generateAcceptanceTestsTemplate() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-No-Created-State");
		ATTemplateGenerator generator = new ATTemplateGenerator(SCSDWithTwoObligations);
		generator.generateATTemplates();
	}
	
}




