package sprint1;

import java.util.Observable;

public class Kasilla extends Observable {
	 private boolean begiratuta=false;
	 private Ontzia ontzi;
	 private boolean ura=true;
	 private int x=0;
	 private int y=0;
	 private boolean urperatuta=false;
	 //junit
	  private boolean ikututa=false;
	  

	 public Kasilla(int i, int j){
	  x = i;
	  y = j;
	 }

	 public Ontzia getOntzia() {
	  return this.ontzi;
	 }

	 public void ontziaJarri(Ontzia o) {
	  this.ontzi=o;
	 }

	 public void kenduUra() {
	  this.ura=false;
	 }

	 public char getZerNahiz() {
	  if(ontzi!=null){
	   return 'U';
	  }
	  else{
	   return 'B';
	  }
	 }
	 public int getX() {
	  return x;
	 }
	 public int getY() {
	  return y;
	 }

	 public void setBegiratuta(boolean b) {
	  begiratuta=b;
	  setChanged();
	  notifyObservers();
	 }

	 public boolean getBegiratuta() {
	  return begiratuta;
	 }

	 //junit
	// public int ikutuGabe() {
	//  if(this.ikutuGabe){
	//   return 1;
	//  }else{
	//   return 0;
	//  }
	//  
	// }

	// public void setIkutuGabe(boolean b) {
	//  this.ikutuGabe=b;
	//  
	// }

	 public void setUrperatuta(boolean b) {
	  this.urperatuta=b;
	  
	 }

	 public boolean getUrperatuta() {
	  return this.urperatuta;
	 }
//	 public void markatuIkututa(boolean b) {
//	  this.ikututa=b;
//	  
//	 }
//
	 public boolean getIkututa() {
	  return this.ikututa;
	 }

//	 public int ikutuGabe() {
//	  if(this.ikutuGabe){
//	   return 1;
//	  }else{
//	   return 0;
//	  }
//	 }
//
//	 public void setIkutuGabe(boolean b) {
//	  this.ikutuGabe=b;
//	 }

	}