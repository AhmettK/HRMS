package kodlamaio.Hrms.adapters;

import java.rmi.RemoteException;

import kodlamaio.Hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter {
	public boolean isReal(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getIdentityNumber()),
					candidate.getFirstName().toUpperCase(),
					candidate.getLastName().toUpperCase(), 
					candidate.getBirthDate());
		}
		catch(NumberFormatException e) {
			System.out.println("gerçek bir kisi degil");
		}
		catch(RemoteException e) {
			System.out.println("gerçek bir kisi degil");
		}
		return result;
	}
}
