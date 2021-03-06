package ch.lars.your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;
import ch.lars.your.app.eomodel.BestellPosition;
import ch.lars.your.app.eomodel.Bestellung;
import ch.lars.your.app.eomodel.Kunde;

/**
 * BestaetigungsSeite Seite wenn der Kunde seinen Kauf und seine Daten
 * Bestätigen möchte
 * 
 * @author Protoss
 *
 */
public class BestaetigungsSeite extends BaseComponent {

	private Kunde kunde;
	private Bestellung bestellung;
	/**
	 * 
	 */
	private static final long serialVersionUID = 728437930614992687L;

	/**
	 * Konstruktor BestaetigungsSeite
	 * 
	 * @param context
	 *            super
	 */
	public BestaetigungsSeite(WOContext context) {
		super(context);
		// nextPage.setKunde(session().getKunde());
		// session().setKunde(session().getKunde());
		// nextPage.setBestellung(session().getBestellung());
		// session().setBestellung(session().getBestellung());

	}

	/**
	 * Abbruch in bei BestaetigungsSeite Terminiert die Session
	 * 
	 * @return Main Seite
	 */
	public Main abbrechen() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

	/**
	 * Geht eine Seite Zurück zum Kunden Formular
	 * 
	 * @return KundenInfoSeite Seite
	 */
	public KundenInfoSeite zurueck() {
		// KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		// session().getKunde().delete();
		// session().getBestellung().delete();
		// return nextPage;
		return null;
	}

	/**
	 * Bestätigung vom Kauf Kunde, Bestellung und Bestellposition wird in der
	 * Datenbank gespeichert
	 * 
	 * @return DankesSeite Seite
	 */
	public final WOComponent commit() {
		session().setKunde(session().getKunde());
		session().setBestellung(session().getBestellung());
		NSMutableArray<BestellPosition> alleBestellPositionen = session().getArikelInhaltKombination();
		alleBestellPositionen
				.forEach(allesVonDerBestellung -> allesVonDerBestellung.setBestellung(session().getBestellung()));
		NSTimestamp now = new NSTimestamp();
		session().getKunde().setKundeseit(now);
		session().getBestellung().setDatum(now);
		session().getBestellung().setKundeRelationship(session().getKunde());
		session().defaultEditingContext().saveChanges();
		return pageWithName(DankesSeite.class);
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		if (session().getNachnameNeuerKunde() == "") {
			System.out.println("nachname ist nicht gesetzt!");
			return "leer";
		} else {
			return session().getNachnameNeuerKunde();
		}
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

}