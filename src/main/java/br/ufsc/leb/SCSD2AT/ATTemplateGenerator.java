package br.ufsc.leb.SCSD2AT;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ATTemplateGenerator {
	
	SCSD scsd;
	
	List<String> activeObligations = new ArrayList<String>();
	
	List<String> activePowers = new ArrayList<String>();
	
	List<String> parties; 
	

	public ATTemplateGenerator(SCSD scsd) {
		this.scsd = scsd;
	}

	
	public void generateATTemplates() {
		generateCreationFeature();
		generateObligationActivationFeature();
		generatePowerActivationFeature(); 
		generateSuspensionFeature();
		generatePartyReplacementFeature();
		generateSuccessfulTerminationFeature();
		generateUnsuccessfulTerminationFeature();	
	}	

	
	private void generateCreationFeature() {
		PrintWriter writer = null;
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-Creation.feature";
			writer = new PrintWriter(path, "UTF-8");			
			
			writer.println("Feature: " + this.scsd.getName() + " Creation");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println();
			
			if (this.scsd.hasCreatedState()){
				
				writer.println("Scenario: Create the " + this.scsd.getName() + " contract");
				writer.println("Given <all information about the smart contract>");
				writer.println("When <the contract is created>");
				writer.println("Then <assure that the contract is correct and not activated>");
				writer.println();

				writer.println("Scenario: Activate the " + this.scsd.getName() + " contract");
				writer.println("Given <all information about the smart contract>");
				writer.println("And <the contract is created>");
				writer.println("When <the contract is activated>");
				writer.println("Then <assure that the contract is corrected and activated>");

			}
			
			else {
			
				writer.println("Scenario: Activate the " + this.scsd.getName() + " contract");
				writer.println("Given <all information about the smart contract>");
				writer.println("And <the contract is created>");
				writer.println("Then <assure that the contract is corrected and activated>");
			}
						
			this.activeObligations = this.scsd.getObligationsActivated();
			this.activePowers = this.scsd.getPowersActivated();
			this.parties = this.scsd.getPartiesOfTheContract();
						
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}					
	}
		
	
	private void generateObligationActivationFeature() {
		PrintWriter writer = null;
		List listObligationsAndTheirPowers = this.scsd.getObligationsToBeActivatedLater();
		if (!listObligationsAndTheirPowers.isEmpty()) {
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-LaterObligationActivation.feature";
			writer = new PrintWriter(path, "UTF-8");			
			
			writer.println("Feature: " + this.scsd.getName() + " Later Obligation Activation");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println("And <all information about the smart contract>");
			writer.println("And <the contract is created and activated>");
			writer.println();
			
			for (int countScenarios = 1; countScenarios <= listObligationsAndTheirPowers.size(); countScenarios++) {
				List<String> obligationAndItsPower = (List) listObligationsAndTheirPowers.get(countScenarios-1);
				
				String obligation = obligationAndItsPower.get(0);
				String power = obligationAndItsPower.get(1);
				
				writer.println("Scenario: Later Obligation Activation #" + Integer.toString(countScenarios) + 
						" of " + this.scsd.getName() + " contract");			
				writer.println("Given <information necessary to the scenario>");
				writer.println("When <" + obligation + " is activated by " + power + ">");
				writer.println("And <any set of obligations that can successfully terminate the contract is fulfilled>");
				writer.println("Then <assure that the contract is successfully terminated>");
				writer.println();
				
			}					
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		}
	}

	
	private void generatePowerActivationFeature() {
		PrintWriter writer = null;
		List listPowersAndTheirPowers = this.scsd.getPowersToBeActivatedLater();
		if (!listPowersAndTheirPowers.isEmpty()) {
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-LaterPowerActivation.feature";
			writer = new PrintWriter(path, "UTF-8");			

			writer.println("Feature: " + this.scsd.getName() + " Later Power Activation");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println("And <all information about the smart contract>");
			writer.println("And <the contract is created and activated>");
			writer.println();
			
			for (int countScenarios = 1; countScenarios <= listPowersAndTheirPowers.size(); countScenarios++) {
				List<String> powerAndItsPower = (List) listPowersAndTheirPowers.get(countScenarios-1);
				
				String newPower = powerAndItsPower.get(0);
				String power = powerAndItsPower.get(1);
				
				writer.println("Scenario: Later Power Activation #" + Integer.toString(countScenarios) + 
						" of " + this.scsd.getName() + " contract");			
				writer.println("Given <information necessary to the scenario>");
				writer.println("When <" + newPower + " is activated by " + power + ">");
				writer.println("And <any set of obligations that can successfully terminate the contract is fulfilled>");
				writer.println("Then <assure that the contract is successfully terminated>");
				writer.println();
				
			}					
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		}
		
	}


	private void generateSuspensionFeature() {
		PrintWriter writer = null;
		List listOfPowersSuspension = (List) this.scsd.getPowersThatSuspendTheContract();
		if (!listOfPowersSuspension.isEmpty()) {
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-Suspension.feature";
			writer = new PrintWriter(path, "UTF-8");			
			
			writer.println("Feature: " + this.scsd.getName() + " Suspension");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println("And <all information about the smart contract>");
			writer.println("And <the contract is created and activated>");
			writer.println();
			
			String powerSuspension = "";
			int countScenarios = 0;
			for (int countPowerSuspension = 0; countPowerSuspension < listOfPowersSuspension.size(); countPowerSuspension++) {
				writer.println();	
				countScenarios += 1;
				powerSuspension = (String) listOfPowersSuspension.get(countPowerSuspension);
				
				writer.println("Scenario: Suspension #" + Integer.toString(countScenarios) + " of " + this.scsd.getName() + " contract");			
				writer.println("Given <information necessary to the scenario>");
				writer.println("When <" + powerSuspension + ">");
				writer.println("Then <assure that the contract and obligations are suspended>");
			
				List listOfPowersResume = (List) this.scsd.getPowersThatResumeTheContract();
				if (!listOfPowersResume.isEmpty()) {
					String powerResume = "";
					for (int countPowerResume = 0; countPowerResume < listOfPowersResume.size(); countPowerResume++) {
						powerResume = (String) listOfPowersResume.get(countPowerResume);
						countScenarios += 1;
	
						writer.println();	
						writer.println("Scenario: Suspension #" + Integer.toString(countScenarios) + " of " + this.scsd.getName() + " contract");			
						writer.println("Given <information necessary to the scenario>");
						writer.println("And <" + powerSuspension + ">");
						writer.println("When <" + powerResume + ">");
						writer.println("Then <assure that the contract and obligations are resumed>");
							
					}
				}
			}
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		}
			
	}
	
	
	private void generatePartyReplacementFeature() {
		PrintWriter writer = null;
		String power = this.scsd.getPowerThatReplaceParties();
		if (power != "") {
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-PartyRevocation.feature";
			writer = new PrintWriter(path, "UTF-8");			
			
			writer.println("Feature: " + this.scsd.getName() + " Party Revocation");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println("And <all information about the smart contract>");
			writer.println("And <the contract is created and activated>");
			writer.println();
			
			List listPartiesReplaced = this.scsd.getPartiesReplacedForObligations();
			for (int countScenarios = 1; countScenarios <= listPartiesReplaced.size(); countScenarios++) {
				List oldPartyAndNewPartyAndObligation = (List) listPartiesReplaced.get(countScenarios-1);
				String oldParty = (String) oldPartyAndNewPartyAndObligation.get(0);
				String newParty = (String) oldPartyAndNewPartyAndObligation.get(1);
				String obligation = (String) oldPartyAndNewPartyAndObligation.get(2);
				
				writer.println("Scenario: Party Replacement #" + Integer.toString(countScenarios) + 
						" of " + this.scsd.getName() + " contract");			
				writer.println("Given <information necessary to the scenario>");
				writer.println("When <" + power + ">");
				writer.println("And <replace the party " + oldParty + " by party " + newParty + " for obligation " + obligation + ">");
				writer.println("Then <assure that the party " + oldParty + " is replaced by party " + newParty + " for obligation " + obligation + ">");
				writer.println();
				
			}					
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		}
	}
	
	
	private void generateSuccessfulTerminationFeature() {
		PrintWriter writer = null;
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-SuccessfulTermination.feature";
			writer = new PrintWriter(path, "UTF-8");						
			
			writer.println("Feature: " + this.scsd.getName() + " Successful Termination");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println("And <all information about the smart contract>");
			writer.println("And <the contract is created and activated>");
			writer.println();
			
//			We are considering there are different lists of obligations that 
//			can successfully terminate a contract. Each list is composed by 
//			obligations connected by AND operators. If it is necessary to 
//			include NOT and OR operators, they must be explicitly included in 
//			the text of an obligation.
			
			List listOfListObligations = (List) this.scsd.getObligationsFulfilled();
			List listOfSurvivingObligations = (List) this.scsd.getSurvivingObligations();
			for (int count_scenarios = 1; count_scenarios <= listOfListObligations.size(); count_scenarios++) {
				List listObligations = (List) listOfListObligations.get(count_scenarios-1);
				
				writer.println("Scenario: Successful termination #" + Integer.toString(count_scenarios) + " of " + this.scsd.getName() + " contract");
				writer.println("Given <information necessary to the scenario>");
				writer.println("When <" + listObligations.get(0) + " is fulfilled>");				
				for (int countObligations = 1; countObligations < listObligations.size(); countObligations++) {
					writer.println("And <" + listObligations.get(countObligations) + " is fulfilled>");
				}	
				if (!listOfSurvivingObligations.isEmpty()) {
					for (int countSurvivingObligations = 0; countSurvivingObligations < listOfSurvivingObligations.size(); countSurvivingObligations++) {
						writer.println("And <" + listOfSurvivingObligations.get(countSurvivingObligations) + " is fulfilled>");
					}	
				}
				writer.println("Then <assure that the contract is successfully terminated>");
				writer.println();	
				
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
	}

	
	
	private void generateUnsuccessfulTerminationFeature() {
		PrintWriter writer = null;
		try {
			String path = "src/main/generated-templates/" + this.scsd.getName() + "-UnsuccessfulTermination.feature";
			writer = new PrintWriter(path, "UTF-8");			
			
			writer.println("Feature: " + this.scsd.getName() + " Unsuccessful Termination");
			writer.println();
			writer.println("Background:");
			writer.println("Given <smart contract setup, including participants>");
			writer.println("And <all information about the smart contract>");
			writer.println("And <the contract is created and activated>");
			writer.println();
			
//			We are considering there are different powers that can 
//			unsuccessfully terminate a contract, connected by OR operators. 
//			If it is necessary to represent an obligation, it must be 
//			explicitly included in the text of a power.
		
			List<String> listPowers = (List) this.scsd.getPowersUnfulfilled();
			List<String> listPenalties = (List) this.scsd.getPenalties();			
			for (int countScenarios = 1; countScenarios <= listPowers.size(); countScenarios++) {
				String power = listPowers.get(countScenarios-1);
				
				writer.println("Scenario: Unsuccessful termination #" + Integer.toString(countScenarios) + " of " + this.scsd.getName() + " contract");
				writer.println("Given <information necessary to the scenario>");
				writer.println("When <" + power + ">");
				writer.println("Then <assure that the contract is terminated>");	
				for (int countPenalties = 0; countPenalties < listPenalties.size(); countPenalties++) {
					writer.println("And <" + listPenalties.get(countPenalties) + ">");
				}	
				writer.println();	
				
				if (this.scsd.hasSuspendedState()) {
					writer.println("Scenario: Unsuccessful termination #" + Integer.toString(countScenarios) + " of " + this.scsd.getName() + " contract");
					writer.println("Given <information necessary to the scenario>");
					writer.println("And <the contract is in the suspended state>");	
					writer.println("When <" + power + ">");
					writer.println("Then <assure that the contract is terminated>");	
					for (int countPenalties = 0; countPenalties < listPenalties.size(); countPenalties++) {
						writer.println("And <" + listPenalties.get(countPenalties) + ">");
					}	
					writer.println();	
				}
			}
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}				
	}

}
