package br.ufsc.leb.SCSD2AT;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SCSD_JSON implements SCSD{

	private JSONParser jsonParser;
	private JSONObject jsonObject;

	
	public SCSD_JSON (String JSONFileName) {
		String completeFileName = "./src/main/resources/scsd_jsons/" + JSONFileName + ".json";
		this.jsonParser = new JSONParser();		
		try {
			this.jsonObject = (JSONObject) this.jsonParser.parse(new FileReader(completeFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}				
	}
	
	
	public String getName() {
		return (String) jsonObject.get("name");
	}
	
	
	public boolean hasCreatedState() {
		JSONObject states = (JSONObject) jsonObject.get("states");
		return states.containsKey("created");
	}

	
	public boolean hasSuspendedState() {
		JSONObject states = (JSONObject) jsonObject.get("states");
		return states.containsKey("suspended");
	}

	
	public List<String> getObligationsCreated() {
		List<String> listObligations = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("create contract");
		if (jsonTransition != null) {
			JSONArray jsonObligations = (JSONArray) jsonTransition.get("obligations_to_be_created");	
			if (jsonObligations != null)
				for(Object obligation : jsonObligations)
				{
					listObligations.add(obligation.toString());
				}
		}
		else {
			jsonTransition = (JSONObject) transitions.get("create activate contract");
			if (jsonTransition != null) {
				JSONArray jsonObligations = (JSONArray) jsonTransition.get("obligations_to_be_activated");	
				if (jsonObligations != null)
					for(Object obligation : jsonObligations)
					{
						listObligations.add(obligation.toString());
					}
			}
		}
		return listObligations;
	}	
	

	public List<String> getPowersCreated() {
		List<String> listPowers = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("create contract");
		if (jsonTransition != null) {
			JSONArray jsonPowers = (JSONArray) jsonTransition.get("powers_to_be_created");	
			if (jsonPowers != null)
				for(Object power : jsonPowers)
				{
					listPowers.add(power.toString());
				}
		}
		else {
			jsonTransition = (JSONObject) transitions.get("create activate contract");
			if (jsonTransition != null) {
				JSONArray jsonPowers = (JSONArray) jsonTransition.get("powers_to_be_activated");	
				if (jsonPowers != null)
					for(Object obligation : jsonPowers)
					{
						listPowers.add(obligation.toString());
					}
			}
		}
		return listPowers;
	}


	public List<String> getObligationsActivated() {
		List<String> listObligations = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("activate contract");
		if (jsonTransition != null) {
			JSONArray jsonObligations = (JSONArray) jsonTransition.get("obligations_to_be_activated");	
			if (jsonObligations != null)
				for(Object obligation : jsonObligations)
				{
					listObligations.add(obligation.toString());
				}
		}
		else {
			jsonTransition = (JSONObject) transitions.get("create activate contract");
			if (jsonTransition != null) {
				JSONArray jsonObligations = (JSONArray) jsonTransition.get("obligations_to_be_activated");	
				if (jsonObligations != null)
					for(Object obligation : jsonObligations)
					{
						listObligations.add(obligation.toString());
					}
			}
		}
		return listObligations;
	}
	
	
	public List<String> getPowersActivated() {		
		List<String> listPowers = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("activate contract");
		if (jsonTransition != null) {
			JSONArray jsonPowers = (JSONArray) jsonTransition.get("powers_to_be_activated");
			if (jsonPowers != null)
				for(Object power : jsonPowers)
				{
					listPowers.add(power.toString());
				}
		}
		else {
			jsonTransition = (JSONObject) transitions.get("create activate contract");
			if (jsonTransition != null) {
				JSONArray jsonPowers = (JSONArray) jsonTransition.get("powers_to_be_activated");	
				if (jsonPowers != null)
					for(Object obligation : jsonPowers)
					{
						listPowers.add(obligation.toString());
					}
			}
		}
		return listPowers;
	}

	
	// ACTIVATION OF NEW OBLIGATIONS AND NEW POWERS
	
	public List<String> getObligationsToBeActivatedLater(){
		List listOfListObligations = new ArrayList();	
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("activate obligation");
		if (jsonTransition != null) {
			JSONArray jsonSetOfLists = (JSONArray) jsonTransition.get("set_of_obligations_that_can_be_activated");
			for(Object jsonList : jsonSetOfLists)
			{
				List<String> obligationAndPower = new ArrayList<String>();
				List listOfObligations = (List) jsonList;
				for (Object element: listOfObligations) {
					obligationAndPower.add(element.toString());
				}	
				listOfListObligations.add(obligationAndPower);
			}
		}
		return listOfListObligations;
	}
	
		
	public List<String> getPowersToBeActivatedLater(){
		List listOfListPowers = new ArrayList();	
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("activate power");
		if (jsonTransition != null) {
			JSONArray jsonSetOfLists = (JSONArray) jsonTransition.get("set_of_powers_that_can_be_activated");
			for(Object jsonList : jsonSetOfLists)
			{
				List<String> powerEPower = new ArrayList<String>();
				List listOfPowers = (List) jsonList;
				for (Object element: listOfPowers) {
					powerEPower.add(element.toString());
				}	
				listOfListPowers.add(powerEPower);
			}
		}
		return listOfListPowers;
	}
	
	
	// SUSPENSION OF THE CONTRACT
	
	public List<String> getPowersThatSuspendTheContract() {
		List<String> listPowers = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("suspend contract");
		if (jsonTransition != null) {
			List<String> listOfPowers = (List) jsonTransition.get("powers_that_suspend_the_contract");					
			for (String power: listOfPowers) {
				listPowers.add(power);
			}
		}
		return listPowers;
	}
			

	public List<String> getPowersThatResumeTheContract() {
			List<String> listPowers = new ArrayList<String>();		
			JSONObject transitions = (JSONObject) jsonObject.get("transitions");
			JSONObject jsonTransition = (JSONObject) transitions.get("resume contract");
			if (jsonTransition != null) {
				List<String> listOfPowers = (List) jsonTransition.get("powers_that_resume_the_contract");					
				for (String power: listOfPowers) {
					listPowers.add(power);
				}
			}
			return listPowers;
		}
				

	// PARTIES
	
	public List<String> getPartiesOfTheContract(){
		List<String> listParties = new ArrayList<String>();		
		JSONArray jsonParties = (JSONArray) jsonObject.get("parties");
		if (jsonParties != null) {
			for(Object jsonParty : jsonParties) {
				JSONObject party = (JSONObject) jsonParty;
				String name = (String) party.get("name");
				listParties.add(name);				
			}
		}
		return listParties;
	}
	
	
	public List getPartiesAndTheirObligationsOfTheContract(){
		List listParties = new ArrayList<String>();		
		JSONArray jsonParties = (JSONArray) jsonObject.get("parties");
		if (jsonParties != null) {
			for(Object jsonParty : jsonParties) {
				JSONObject party = (JSONObject) jsonParty;
				String name = (String) party.get("name");
				JSONArray jsonObligations = (JSONArray) party.get("obligations");
				if (jsonObligations != null){
					for(Object jsonObligation : jsonObligations) {
						List<String> listPartyObligation = new ArrayList<String>();
						listPartyObligation.add(name);
						listPartyObligation.add(jsonObligation.toString());
						listParties.add(listPartyObligation);
					}
				}
			}
		}
		return listParties;
	}
	

	public List getPartiesAndTheirPowersOfTheContract() {
		List listParties = new ArrayList<String>();		
		JSONArray jsonParties = (JSONArray) jsonObject.get("parties");
		if (jsonParties != null) {
			for(Object jsonParty : jsonParties) {
				JSONObject party = (JSONObject) jsonParty;
				String name = (String) party.get("name");
				JSONArray jsonPowers = (JSONArray) party.get("powers");
				if (jsonPowers != null){
					for(Object jsonPower : jsonPowers) {
						List<String> listPartyPower = new ArrayList<String>();
						listPartyPower.add(name);
						listPartyPower.add(jsonPower.toString());
						listParties.add(listPartyPower);
					}
				}
			}
		}
		return listParties;
		
	}

	
	public String getPowerThatReplaceParties() {
		String power = "";		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("replace party");
		if (jsonTransition != null) {
			power = (String) jsonTransition.get("power_that_replace_a_party");	
		}
		return power;
	}

	
	public List getPartiesReplacedForObligations() {
		List listOfListOldPartyNewPartObligation = new ArrayList();	
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("replace party");
		if (jsonTransition != null) {
			JSONArray jsonSetOfLists = (JSONArray) jsonTransition.get("parties_that_can_be_replaced");
			for(Object jsonList : jsonSetOfLists)
			{
				List<String> oldPartyNewPartObligation = new ArrayList<String>();
				List listOfObligations = (List) jsonList;
				for (Object element: listOfObligations) {
					oldPartyNewPartObligation.add(element.toString());
				}	
				listOfListOldPartyNewPartObligation.add(oldPartyNewPartObligation);
			}
		}
		return listOfListOldPartyNewPartObligation;
	}
	
	
	
	// SUCCESS TERMINATION
	
	public List getObligationsFulfilled() {
		List listOfListObligations = new ArrayList();	
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("fulfill active obligations");
		if (jsonTransition != null) {
			JSONArray jsonSetOfLists = (JSONArray) jsonTransition.get("lists_obligations_to_be_fulfilled");
			for(Object jsonList : jsonSetOfLists)
			{
				List<String> obligations = new ArrayList<String>();
				List listOfObligations = (List) jsonList;
				for (Object element: listOfObligations) {
					obligations.add(element.toString());
				}	
				listOfListObligations.add(obligations);
			}
		}
		return listOfListObligations;
	}

	
	// UNSUCCESSFUL TERMINATION
	
	public List<String> getPowersUnfulfilled() {
		List<String> listPowers = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("terminate contract");
		if (jsonTransition != null) {
			List<String> jsonList = (List) jsonTransition.get("list_powers");
			for(String power : jsonList) {
				listPowers.add(power);
			}
		}	
		return listPowers;
	}

	
	public List<String> getPenalties(){
		List<String> listPenalties = new ArrayList<String>();		
		JSONObject transitions = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonTransition = (JSONObject) transitions.get("terminate contract");
		if (jsonTransition != null) {
			List<String> jsonList = (List) jsonTransition.get("penalties");
			if (jsonList != null){
				for(String penalty : jsonList) {
					listPenalties.add(penalty);
				}
			}
		}	
		return listPenalties;		
	}

	
	public List<String> getSurvivingObligations() {
		List<String> listSurvivingObligations = new ArrayList<String>();		
		JSONObject states = (JSONObject) jsonObject.get("transitions");
		JSONObject jsonState = (JSONObject) states.get("fulfill active obligations");
		JSONArray jsonSurvivingObligations = (JSONArray) jsonState.get("surviving_obligations_to_be_activated");	
		if (jsonSurvivingObligations != null) {
			for(Object survivingObligation : jsonSurvivingObligations)
			{
				listSurvivingObligations.add(survivingObligation.toString());
			}
		}	
		return listSurvivingObligations;
	}

	
}




