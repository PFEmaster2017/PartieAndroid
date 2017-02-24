package entities;

import java.util.Date;

public class Voiture {
public int num_enrg;
public int person_cin;
public  Date dat_enregitre;
public String depot;
public String description_voiture;
public String person_name;
public String person_prenom;
public String source;

public Voiture() {
	super();
	// TODO Auto-generated constructor stub
}
public Voiture(int num_enrg, int person_cin, Date dat_enregitre, String depot,
		String description_voiture, String person_name, String person_prenom,
		String source) {
	super();
	this.num_enrg = num_enrg;
	this.person_cin = person_cin;
	this.dat_enregitre = dat_enregitre;
	this.depot = depot;
	this.description_voiture = description_voiture;
	this.person_name = person_name;
	this.person_prenom = person_prenom;
	this.source = source;
}
public int getNum_enrg() {
	return num_enrg;
}
public void setNum_enrg(int num_enrg) {
	this.num_enrg = num_enrg;
}
public int getPerson_cin() {
	return person_cin;
}
public void setPerson_cin(int person_cin) {
	this.person_cin = person_cin;
}
public Date getDat_enregitre() {
	return dat_enregitre;
}
public void setDat_enregitre(Date dat_enregitre) {
	this.dat_enregitre = dat_enregitre;
}
public String getDepot() {
	return depot;
}
public void setDepot(String depot) {
	this.depot = depot;
}
public String getDescription_voiture() {
	return description_voiture;
}
public void setDescription_voiture(String description_voiture) {
	this.description_voiture = description_voiture;
}
public String getPerson_name() {
	return person_name;
}
public void setPerson_name(String person_name) {
	this.person_name = person_name;
}
public String getPerson_prenom() {
	return person_prenom;
}
public void setPerson_prenom(String person_prenom) {
	this.person_prenom = person_prenom;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
}
