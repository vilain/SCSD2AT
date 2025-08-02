package br.ufsc.leb.SCSD2AT;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Test_SCSD_JSON_ThreeObligations_ThreePowers_Suspension extends TestCase {

	
    public Test_SCSD_JSON_ThreeObligations_ThreePowers_Suspension ( )
    {
        super( );
    }

    public static Test suite()
    {
        return new TestSuite( Test_SCSD_JSON_ThreeObligations_ThreePowers_Suspension.class );
    }
    
    
    // Creation    

 	public void test_getName() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		assertEquals ("SC-Three-Obligations-Three-Powers-Suspension", scsd.getName());
	}
 	
 	public void test_hasCreatedState() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		assertTrue (scsd.hasCreatedState());
	}

 	public void test_hasSuspendedState() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		assertTrue (scsd.hasSuspendedState());
	}

	public void test_getObligationsAndPowersToBeCreatedInTransitionFromInitialToCreated() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listObligations = scsd.getObligationsCreated();
		assertEquals (3, listObligations.size());
		assertEquals ("obligation 1", listObligations.get(0));	
		assertEquals ("obligation 2", listObligations.get(1));	
		assertEquals ("obligation 3", listObligations.get(2));	
		List<String> listPowers = scsd.getPowersCreated();
		assertEquals (8, listPowers.size());
		assertEquals ("power 1", listPowers.get(0));	
		assertEquals ("power 2", listPowers.get(1));	
		assertEquals ("power 3", listPowers.get(2));	
		assertEquals ("power 4", listPowers.get(3));	
		assertEquals ("power 5", listPowers.get(4));	
		assertEquals ("power 6", listPowers.get(5));	
		assertEquals ("power 7", listPowers.get(6));	
		assertEquals ("power 8", listPowers.get(7));	
	}

	public void test_getObligationsAndPowersActivatedInTransitionFromCreatedToInEffect() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listObligations = scsd.getObligationsActivated();
		assertEquals (3, listObligations.size());
		assertEquals ("obligation 1", listObligations.get(0));	
		assertEquals ("obligation 2", listObligations.get(1));	
		assertEquals ("obligation 3", listObligations.get(2));	
		List<String> listPowers = scsd.getPowersActivated();
		assertEquals (8, listPowers.size());
		assertEquals ("power 1", listPowers.get(0));	
		assertEquals ("power 2", listPowers.get(1));	
		assertEquals ("power 3", listPowers.get(2));	
		assertEquals ("power 4", listPowers.get(3));	
		assertEquals ("power 5", listPowers.get(4));	
		assertEquals ("power 6", listPowers.get(5));	
		assertEquals ("power 7", listPowers.get(6));	
		assertEquals ("power 8", listPowers.get(7));	
	}
	
    // Activation of obligations and powers

	public void test_getSetOfObligationsToBeActivatedLaterInTransitionFromInEffectToInEffect() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listOfListObligations = SCSDWithTwoObligations.getObligationsToBeActivatedLater();
		assertEquals (1, listOfListObligations.size());
		assertEquals ("obligation 10", ((List)listOfListObligations.get(0)).get(0));	
		assertEquals ("power 1", ((List)listOfListObligations.get(0)).get(1));	
	}

	public void test_getSetOfPowersToBeActivatedLaterInTransitionFromInEffectToInEffect() {
		SCSD SCSDWithTwoObligations = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listOfListPowers = SCSDWithTwoObligations.getPowersToBeActivatedLater();
		assertEquals (1, listOfListPowers.size());
		assertEquals ("power 10", ((List)listOfListPowers.get(0)).get(0));	
		assertEquals ("power 1", ((List)listOfListPowers.get(0)).get(1));	
	}
	

    // Suspension and resume of the contract

	public void test_getPowersThatSuspendTheContractInTransitionFromInEffectToSuspended() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listPowers = scsd.getPowersThatSuspendTheContract();
		assertEquals (2, listPowers.size());
		assertEquals ("power 4", listPowers.get(0));
		assertEquals ("power 5", listPowers.get(1));
	}

	public void test_getPowersThatResumeTheContractInTransitionFromSuspendedToInEffect() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listPowers = scsd.getPowersThatResumeTheContract();
		assertEquals (2, listPowers.size());
		assertEquals ("power 1", listPowers.get(0));
		assertEquals ("power 2", listPowers.get(1));
	}

	
    // Parties

	public void test_getListOfPartiesOfTheContract() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listParties = scsd.getPartiesOfTheContract();
		assertEquals (3, listParties.size());
		assertEquals ("party 1", listParties.get(0));	
		assertEquals ("party 2", listParties.get(1));	
		assertEquals ("party 3", listParties.get(2));	
	}
	
	public void test_getPartiesAndTheirObligations() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listPartiesAndObligations = scsd.getPartiesAndTheirObligationsOfTheContract();
		assertEquals (3, listPartiesAndObligations.size());
		assertEquals ("party 1", ((List)listPartiesAndObligations.get(0)).get(0));	
		assertEquals ("obligation 1", ((List)listPartiesAndObligations.get(0)).get(1));	
		assertEquals ("party 1", ((List)listPartiesAndObligations.get(1)).get(0));	
		assertEquals ("obligation 3", ((List)listPartiesAndObligations.get(1)).get(1));	
		assertEquals ("party 2", ((List)listPartiesAndObligations.get(2)).get(0));	
		assertEquals ("obligation 2", ((List)listPartiesAndObligations.get(2)).get(1));	
	}
	
	public void test_getPartiesAndTheirPowers() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listPartiesAndPowers = scsd.getPartiesAndTheirPowersOfTheContract();
		assertEquals (8, listPartiesAndPowers.size());
		assertEquals ("party 1", ((List)listPartiesAndPowers.get(0)).get(0));	
		assertEquals ("power 1", ((List)listPartiesAndPowers.get(0)).get(1));	
		assertEquals ("party 2", ((List)listPartiesAndPowers.get(1)).get(0));	
		assertEquals ("power 3", ((List)listPartiesAndPowers.get(1)).get(1));	
		assertEquals ("party 3", ((List)listPartiesAndPowers.get(2)).get(0));	
		assertEquals ("power 2", ((List)listPartiesAndPowers.get(2)).get(1));	
		assertEquals ("party 3", ((List)listPartiesAndPowers.get(3)).get(0));	
		assertEquals ("power 4", ((List)listPartiesAndPowers.get(3)).get(1));	
		assertEquals ("party 3", ((List)listPartiesAndPowers.get(4)).get(0));	
		assertEquals ("power 5", ((List)listPartiesAndPowers.get(4)).get(1));	
		assertEquals ("party 3", ((List)listPartiesAndPowers.get(5)).get(0));	
		assertEquals ("power 6", ((List)listPartiesAndPowers.get(5)).get(1));	
		assertEquals ("party 3", ((List)listPartiesAndPowers.get(6)).get(0));	
		assertEquals ("power 7", ((List)listPartiesAndPowers.get(6)).get(1));	
		assertEquals ("party 3", ((List)listPartiesAndPowers.get(7)).get(0));	
		assertEquals ("power 8", ((List)listPartiesAndPowers.get(7)).get(1));	
	}
		
	public void test_getPowerThatReplaceParties() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		String power = scsd.getPowerThatReplaceParties();
		assertEquals ("power 6", power);	
	}	
	
	public void test_getPartiesReplacedInTransitionFromActiveToActive() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listOldPartyNewPartyObligation = scsd.getPartiesReplacedForObligations();
		assertEquals (2, listOldPartyNewPartyObligation.size());
		assertEquals ("party 1", ((List)listOldPartyNewPartyObligation.get(0)).get(0));	
		assertEquals ("party 2", ((List)listOldPartyNewPartyObligation.get(0)).get(1));	
		assertEquals ("obligation 1", ((List)listOldPartyNewPartyObligation.get(0)).get(2));	
		assertEquals ("party 2", ((List)listOldPartyNewPartyObligation.get(1)).get(0));	
		assertEquals ("party 20", ((List)listOldPartyNewPartyObligation.get(1)).get(1));	
		assertEquals ("obligation 2", ((List)listOldPartyNewPartyObligation.get(1)).get(2));	
	}

	
	// SUCCESSFUL TERMINATION
	
	public void test_getObligationsFulfilledInTransitionFromInEffectToSuccessfulTermination() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List listOfListsObligations = (List) scsd.getObligationsFulfilled();
		assertEquals (3, listOfListsObligations.size());
		List list1 = (List) listOfListsObligations.get(0);
		assertEquals ("obligation 1", (String) list1.get(0));
		assertEquals ("obligation 3", (String) list1.get(1));
		List list2 = (List) listOfListsObligations.get(1);
		assertEquals ("obligation 1", (String) list2.get(0));
		assertEquals ("obligation 2", (String) list2.get(1));
		List list3 = (List) listOfListsObligations.get(2);
		assertEquals ("obligation 2", (String) list3.get(0));
		assertEquals ("obligation 3", (String) list3.get(1));
	}
	
	public void test_getSurvivingObligationsInTransitionFromInEffectToSuccessfulTermination() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listSurvivingObligations = (List<String>) scsd.getSurvivingObligations();
		assertTrue (listSurvivingObligations.isEmpty());
	}

	
	// UNSUCCESSFUL TERMINATION
		
	public void test_getPowersUnfulfilledInTransitionFromInEffectToUnsuccessfulTermination() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listPowers = (List<String>) scsd.getPowersUnfulfilled();
		assertEquals (2, listPowers.size());
		assertEquals ("not obligation 1", listPowers.get(0));
		assertEquals ("not obligation 2 AND power 3", listPowers.get(1));
	}
	
	public void test_getPenaltiesUnfulfilledInTransitionFromInEffectToUnsuccessfulTermination() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		List<String> listPenalties = (List<String>) scsd.getPenalties();
		assertEquals (1, listPenalties.size());
		assertEquals ("penalty 1", listPenalties.get(0));
	}
	

	// GENERATE TEMPLATES
	
	public void test_generateAcceptanceTestsTemplate() {
		SCSD scsd = new SCSD_JSON("SC-Three-Obligations-Three-Powers-Suspension");
		ATTemplateGenerator generator = new ATTemplateGenerator(scsd);
		generator.generateATTemplates();
	}
	
}
