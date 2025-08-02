package br.ufsc.leb.SCSD2AT;

import java.util.List;
import java.util.Map;

public interface SCSD {
	
	public String getName();
	
	public boolean hasCreatedState();
	
	public boolean hasSuspendedState();
	
	public List<String> getObligationsCreated();

	public List<String> getPowersCreated();

	public List<String> getObligationsActivated();

	public List<String> getPowersActivated();
	
	public List<String> getObligationsToBeActivatedLater();
	
	public List<String> getPowersToBeActivatedLater();
	
	public List<String> getPowersThatSuspendTheContract();

	public List<String> getPowersThatResumeTheContract();
	
	public List<String> getPartiesOfTheContract();
	
	public List getPartiesAndTheirObligationsOfTheContract();
	
	public List getPartiesAndTheirPowersOfTheContract();

	public String getPowerThatReplaceParties();

	public List getPartiesReplacedForObligations();

	public List getObligationsFulfilled();
	
	public List<String> getPowersUnfulfilled();
	
	public List<String> getPenalties();
	
	public List<String> getSurvivingObligations();

}
