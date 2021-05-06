import java.awt.*;
import java.awt.event.*;
import java.math.MathContext;
import javax.management.StringValueExp;
import javax.swing.*;

public class Calculadora2 extends JFrame implements ActionListener, KeyListener{
	String temp= "";
	float x, y;
	String texto="";
	int opcion;
	double convert;
	boolean radianes=false, grados=true;

	JMenuBar barraMenu;
	JMenu modo, ver, ayuda;
	JMenuItem estandar, cientifica, oscuro, claro, pantalla_oscura, pantalla_clara, acerca;


	JButton boton1= new JButton("1");
	JButton boton2= new JButton("2");
	JButton boton3= new JButton("3");
	JButton boton4= new JButton("4");
	JButton boton5= new JButton("5");
	JButton boton6= new JButton("6");
	JButton boton7= new JButton("7");
	JButton boton8= new JButton("8");
	JButton boton9= new JButton("9");
	JButton boton0= new JButton("0");
	JButton botonSum= new JButton("+");
	JButton botonRes= new JButton("-");
	JButton botonMult= new JButton("x");
	JButton botonDiv= new JButton("/");
	JButton botonIgual= new JButton("=");
	JButton botonCuad= new JButton("x"+"\u00B2");
	JButton botonCubo= new JButton("x"+"\u00B3");
	JButton botonPot= new JButton("x"+"\u207F");
	JButton botonRaiz= new JButton("\u23B7");
	JButton botonPunto= new JButton(".");
	JButton botonBorrar= new JButton("C");
	JButton botonRetro= new JButton("\u2190");
	JButton botonSeno= new JButton("sen");
	JButton botonCos= new JButton("cos");
	JButton botonTan= new JButton("tan");
	JButton botonFac= new JButton("n!");
	JButton botonRad= new JButton("rad");
	JButton botonGrad= new JButton("°");
	JButton botonPi= new JButton("\u03C0");
	JButton botonLn= new JButton("ln");
	JButton botonLog= new JButton("log");
	JButton botonExp= new JButton("exp");
	JButton botonSigno= new JButton("+/-");
	JButton botonAsen= new JButton("asen");
	JButton botonAcos= new JButton("acos");
	JButton botonAtan= new JButton("atan");
	JButton botonInv= new JButton("x"+"\u207B"+"\u00B9");
	JButton botonConvRad= new JButton("°/r");
	JButton botonConvGrad= new JButton("r/°");


	JTextField pantalla= new JTextField();
	Font fuente= new Font("Arial",Font.BOLD,13);
	Font fuenteBoton= new Font("Arial",Font.BOLD,9);



	public Calculadora2(String nombre){
		super(nombre);
		iniciar();
	}

	public void iniciar(){

		pantalla.setBounds(20,30,260,40);
		pantalla.setFont(fuente);

		barraMenu= new JMenuBar();
		modo= new JMenu("Modo");
		ver= new JMenu("Ver");
		ayuda= new JMenu("Ayuda");
		estandar= new JMenuItem("Estándar");
		cientifica= new JMenuItem("Científica");
		oscuro= new JMenuItem("Modo oscuro");
		claro= new JMenuItem("Modo claro");
		pantalla_oscura= new JMenuItem("Pantalla oscura");
		pantalla_clara= new JMenuItem("Pantalla clara");
		acerca= new JMenuItem("Acerca de Calculadora");

		boton9.setBounds(170,100,60,25);
		boton8.setBounds(110,100,60,25);
		boton7.setBounds(50,100,60,25);
		boton6.setBounds(170,125,60,25);
		boton5.setBounds(110,125,60,25);
		boton4.setBounds(50,125,60,25);
		boton3.setBounds(170,150,60,25);
		boton2.setBounds(110,150,60,25);
		boton1.setBounds(50,150,60,25);
		boton0.setBounds(110,175,60,25);
		botonIgual.setBounds(230,175,60,25);
		botonIgual.setBackground(Color.GREEN);
		botonPunto.setBounds(50,175,60,25);
		botonBorrar.setBounds(230,75,60,25);
		botonBorrar.setBackground(Color.RED);
		botonSum.setBounds(170,175,60,25);
		botonRes.setBounds(230,150,60,25);
		botonMult.setBounds(230,125,60,25);
		botonDiv.setBounds(230,100,60,25);
		botonRaiz.setBounds(0,175,50,25);
		botonCuad.setBounds(0,150,50,25);
		botonCubo.setBounds(0,125,50,25);
		botonPot.setBounds(0,100,50,25);
		botonRetro.setBounds(170,75,60,25);
		botonGrad.setBounds(0,75,50,25);
		botonGrad.setBackground(Color.GREEN);
		botonRad.setBounds(50,75,60,25);
		botonRad.setBackground(Color.BLUE);
		botonSeno.setBounds(50,210,60,25);
		botonCos.setBounds(110,210,60,25);
		botonTan.setBounds(170,210,60,25);
		botonFac.setBounds(50,235,60,25);
		botonPi.setBounds(110,235,60,25);
		botonLn.setBounds(170,235,60,25);
		botonLog.setBounds(50,260,60,25);
		botonExp.setBounds(110,260,60,25);
		botonSigno.setBounds(170,260,60,25);
		botonAsen.setBounds(230,210,60,25);
		botonAsen.setFont(fuenteBoton);
		botonAcos.setBounds(230,235,60,25);
		botonAcos.setFont(fuenteBoton);
		botonAtan.setBounds(230,260,60,25);
		botonAtan.setFont(fuenteBoton);
		botonInv.setBounds(0,210,50,25);
		botonInv.setFont(fuenteBoton);
		botonConvRad.setBounds(0,235,50,25);
		botonConvRad.setFont(fuenteBoton);
		botonConvGrad.setBounds(0,260,50,25);
		botonConvGrad.setFont(fuenteBoton);

		this.setJMenuBar(barraMenu);
		barraMenu.add(modo);
		barraMenu.add(ver);
		barraMenu.add(ayuda);
		modo.add(estandar);
		modo.add(cientifica);
		ver.add(oscuro);
		ver.add(claro);
		ver.add(pantalla_oscura);
		ver.add(pantalla_clara);
		ayuda.add(acerca);



		estandar.addActionListener(this);
		cientifica.addActionListener(this);
		oscuro.addActionListener(this);
		claro.addActionListener(this);
		pantalla_clara.addActionListener(this);
		pantalla_oscura.addActionListener(this);
		acerca.addActionListener(this);

		boton9.addActionListener(this);
		boton9.addKeyListener(this);		
		boton8.addActionListener(this);
		boton8.addKeyListener(this);		
		boton7.addActionListener(this);
		boton7.addKeyListener(this);		
		boton6.addActionListener(this);
		boton6.addKeyListener(this);
		boton5.addActionListener(this);
		boton4.addActionListener(this);
		boton3.addActionListener(this);
		boton2.addActionListener(this);
		boton1.addActionListener(this);
		boton0.addActionListener(this);
		botonIgual.addActionListener(this);
		botonIgual.addKeyListener(this);
		botonPunto.addActionListener(this);
		botonBorrar.addActionListener(this);
		botonSum.addActionListener(this);
		botonSum.addKeyListener(this);
		botonRes.addActionListener(this);
		botonMult.addActionListener(this);
		botonDiv.addActionListener(this);
		botonRaiz.addActionListener(this);
		botonCuad.addActionListener(this);
		botonCubo.addActionListener(this);
		botonPot.addActionListener(this);
		botonRetro.addActionListener(this);
		botonGrad.addActionListener(this);
		botonRad.addActionListener(this);
		botonSeno.addActionListener(this);
		botonCos.addActionListener(this);
		botonTan.addActionListener(this);
		botonFac.addActionListener(this);
		botonPi.addActionListener(this);
		botonLn.addActionListener(this);
		botonLog.addActionListener(this);
		botonExp.addActionListener(this);
		botonSigno.addActionListener(this);
		botonAtan.addActionListener(this);
		botonAcos.addActionListener(this);
		botonAsen.addActionListener(this);
		botonInv.addActionListener(this);
		botonConvRad.addActionListener(this);
		botonConvGrad.addActionListener(this);

		pantalla.addActionListener(this);
		pantalla.addKeyListener(this);
		

		this.getContentPane().add(pantalla);

		this.getContentPane().add(boton9);
		this.getContentPane().add(boton8);
		this.getContentPane().add(boton7);
		this.getContentPane().add(boton6);
		this.getContentPane().add(boton5);
		this.getContentPane().add(boton4);
		this.getContentPane().add(boton3);
		this.getContentPane().add(boton2);
		this.getContentPane().add(boton1);
		this.getContentPane().add(boton0);
		this.getContentPane().add(botonIgual);
		this.getContentPane().add(botonPunto);
		this.getContentPane().add(botonBorrar);
		this.getContentPane().add(botonSum);
		this.getContentPane().add(botonRes);
		this.getContentPane().add(botonMult);
		this.getContentPane().add(botonDiv);
		this.getContentPane().add(botonRaiz);
		this.getContentPane().add(botonCuad);
		this.getContentPane().add(botonCubo);
		this.getContentPane().add(botonPot);
		this.getContentPane().add(botonRetro);
		this.getContentPane().add(botonGrad);
		this.getContentPane().add(botonRad);
		this.getContentPane().add(botonSeno);
		this.getContentPane().add(botonCos);
		this.getContentPane().add(botonTan);
		this.getContentPane().add(botonFac);
		this.getContentPane().add(botonPi);
		this.getContentPane().add(botonLn);
		this.getContentPane().add(botonLog);
		this.getContentPane().add(botonExp);
		this.getContentPane().add(botonSigno);
		this.getContentPane().add(botonAsen);
		this.getContentPane().add(botonAcos);
		this.getContentPane().add(botonAtan);
		this.getContentPane().add(botonInv);
		this.getContentPane().add(botonConvRad);
		this.getContentPane().add(botonConvGrad);

		this.setBounds(400,100,300,350);
	    this.setResizable(isMaximumSizeSet());//desactiva opcion maximizar
    	this.getContentPane().setBackground(Color.LIGHT_GRAY);
    	this.setLayout(null);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void keyTyped(KeyEvent e){
		
	}
	public void keyPressed(KeyEvent e){
	
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			botonIgual.doClick();
		}
		if(e.getKeyCode()==KeyEvent.VK_PLUS){			
			botonSum.doClick();
		}
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){			
			botonBorrar.doClick();			
		}
		if(e.getKeyCode()==KeyEvent.VK_MINUS){//anda mal la resta 
			if(pantalla.getText()==""){
				temp= "-";
				pantalla.setText("-");
			}
			else{
				x=Float.parseFloat(pantalla.getText());
				temp="";
				pantalla.setText("");
				opcion= 2;
			}
												
		}
		if(e.getKeyCode()==KeyEvent.VK_DIVIDE){
			botonDiv.doClick();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			botonRetro.doClick();
		}		
	}
	public void keyReleased(KeyEvent e){
		
	}	
	public void actionPerformed(ActionEvent e){
		pantalla.requestFocus();	
		if(e.getSource()==Calculadora2.this.boton9){
			if(pantalla.getText()==""){
				pantalla.setText(boton9.getText());
				temp=boton9.getText();
			}
			else{
				pantalla.setText(temp+boton9.getText());
				temp += boton9.getText();
			}			
						
		 }
		if(e.getSource()==Calculadora2.this.boton8){
			if(pantalla.getText()==""){
				pantalla.setText(boton8.getText());
				temp=boton8.getText();
			}
			else{
				pantalla.setText(temp+boton8.getText());
				temp += boton8.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.boton7){
			if(pantalla.getText()==""){
				pantalla.setText(boton7.getText());
				temp=boton7.getText();
			}
			else{
				pantalla.setText(temp+boton7.getText());
				temp += boton7.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.boton6){
			if(pantalla.getText()==""){
				pantalla.setText(boton6.getText());
				temp=boton6.getText();
			}
			else{
				pantalla.setText(temp+boton6.getText());
				temp += boton6.getText();
			}		
		}	  
		if(e.getSource()==Calculadora2.this.boton5){
			if(pantalla.getText()==""){
				pantalla.setText(boton5.getText());
				temp=boton5.getText();
			}
			else{
				pantalla.setText(temp+boton5.getText());
				temp += boton5.getText();
			}					
		}
		if(e.getSource()==Calculadora2.this.boton4){
			if(pantalla.getText()==""){
				pantalla.setText(boton4.getText());
				temp=boton4.getText();
			}
			else{
				pantalla.setText(temp+boton4.getText());
				temp += boton4.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.boton3){
			if(pantalla.getText()==""){
				pantalla.setText(boton3.getText());
				temp=boton3.getText();
			}
			else{
				pantalla.setText(temp+boton3.getText());
				temp += boton3.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.boton2){
			if(pantalla.getText()==""){
				pantalla.setText(boton2.getText());
				temp=boton2.getText();
			}
			else{
				pantalla.setText(temp+boton2.getText());
				temp += boton2.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.boton1){
			if(pantalla.getText()==""){
				pantalla.setText(boton1.getText());
				temp=boton1.getText();
			}
			else{
				pantalla.setText(temp+boton1.getText());
				temp += boton1.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.boton0){
			if(pantalla.getText()==""){
				pantalla.setText(boton0.getText());
				temp=boton0.getText();
			}
			else{
				pantalla.setText(temp+boton0.getText());
				temp += boton0.getText();
			}		
		}
		if(e.getSource()==Calculadora2.this.botonPunto){
			if(pantalla.getText()==""){
				temp= "0";				
				pantalla.setText(temp+".");
				temp += ".";
			}
			else{
				pantalla.setText(temp+".");
				temp += ".";
			}
			
		}
		if(e.getSource()==Calculadora2.this.botonSum){
			x=Float.parseFloat(pantalla.getText());
			temp="";
			pantalla.setText("");
			opcion= 1;
		}
		if(e.getSource()==Calculadora2.this.botonRes){

			if(pantalla.getText()==""){
				temp= "-";
				pantalla.setText("-");
			}
			else{
				x=Float.parseFloat(pantalla.getText());
				temp="";
				pantalla.setText("");
				opcion= 2;
			}
			
		}
		if(e.getSource()==Calculadora2.this.botonMult){
			x=Float.parseFloat(pantalla.getText());
			temp="";
			pantalla.setText("");
			opcion= 3;
		}
		if(e.getSource()==Calculadora2.this.botonDiv){
			x=Float.parseFloat(pantalla.getText());
			temp="";
			pantalla.setText("");
			opcion= 4;
		}
		if(e.getSource()==Calculadora2.this.botonRaiz){
			x=Float.parseFloat(pantalla.getText());
			pantalla.setText(String.valueOf(Math.sqrt(x)));
		    x=0;
		}
		if(e.getSource()==Calculadora2.this.botonCuad){
			x=Float.parseFloat(pantalla.getText());
			pantalla.setText(String.valueOf(Math.pow(x,2)));
			x=0;
		}
		if(e.getSource()==Calculadora2.this.botonCubo){
			x=Float.parseFloat(pantalla.getText());
			pantalla.setText(String.valueOf(Math.pow(x,3)));
			x=0;
		}
		if(e.getSource()==Calculadora2.this.botonPot){
			x=Float.parseFloat(pantalla.getText());
			temp="";
			pantalla.setText("");
			opcion= 5;
		}
		if(e.getSource()==Calculadora2.this.botonBorrar){
			pantalla.setText("");
			temp="";
			x=0;
			y=0;
			opcion=0;			
			convert=0;
		}
		if(e.getSource()==Calculadora2.this.botonRetro){
			String temp2="";
       		for (int i = 0; i < pantalla.getText().length()-1; i++){
       			 
				temp2=temp2+pantalla.getText().charAt(i);
			}
                    
			pantalla.setText(temp2);
			temp=temp2;
		}
		if(e.getSource()==Calculadora2.this.botonGrad){
			grados= true;
			radianes= false;
			botonGrad.setBackground(Color.GREEN);
			botonRad.setBackground(Color.BLUE);

		}
		if(e.getSource()==Calculadora2.this.botonRad){
			radianes= true;
			grados= false;
			botonRad.setBackground(Color.GREEN);
			botonGrad.setBackground(Color.BLUE);

		}
		if(e.getSource()==Calculadora2.this.botonSeno){
			if(grados){
				x=Float.parseFloat(pantalla.getText()); 
				convert=(x*Math.PI)/180;//convercion de radianes a sexagesimales
				pantalla.setText("");
				pantalla.setText(String.valueOf(Math.sin(convert)));
				y=0;
				convert=0;
			}
			else{
				x=Float.parseFloat(pantalla.getText());
				pantalla.setText("");
				pantalla.setText(String.valueOf(Math.sin(x)));
				y=0;
				convert=0;
			}
		}
		if(e.getSource()==Calculadora2.this.botonCos){
			if(grados){
				x=Float.parseFloat(pantalla.getText()); 
				convert=Math.toRadians(x);//convercion de grados a radianes
				pantalla.setText("");
				pantalla.setText(String.valueOf(Math.cos(convert)));
				y=0;
				convert=0;
			}
			else{
				x=Float.parseFloat(pantalla.getText());
				pantalla.setText("");
				pantalla.setText(String.valueOf(Math.cos(x)));
				y=0;
				convert=0;
			}

		}
		if(e.getSource()==Calculadora2.this.botonTan){
			if(grados){
				x=Float.parseFloat(pantalla.getText()); 
				convert=Math.toRadians(x);//convercion de grados a radianes
				pantalla.setText("");
				pantalla.setText(String.valueOf(Math.tan(convert)));
				y=0;
				convert=0;
			}
			else{
				x=Float.parseFloat(pantalla.getText());
				pantalla.setText("");
				pantalla.setText(String.valueOf(Math.tan(x)));
				y=0;
				convert=0;
			}

		}
		if(e.getSource()==Calculadora2.this.botonFac){
			double k=1;
			x=Float.parseFloat(pantalla.getText()); 
			pantalla.setText("");
	        for (int i = 1; i <=x; i++){
				k=k*i;
			}
			pantalla.setText(String.valueOf(k));
		}
		if(e.getSource()==Calculadora2.this.botonPi){
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.PI));

		}
		if(e.getSource()==Calculadora2.this.botonLn){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.log(x)));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonLog){
			x= Float.parseFloat(pantalla.getText());
			temp= "";
			pantalla.setText("");
			opcion= 6;

		}
		if(e.getSource()==Calculadora2.this.botonExp){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.exp(x)));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonSigno){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf((-1)*x));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonAsen){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.asin(x)));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonAcos){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.acos(x)));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonAtan){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.atan(x)));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonInv){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(1/x));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonConvRad){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.toRadians(x)));
			y=0;

		}
		if(e.getSource()==Calculadora2.this.botonConvGrad){
			x= Float.parseFloat(pantalla.getText());
			pantalla.setText("");
			pantalla.setText(String.valueOf(Math.toDegrees(x)));
			y=0;

		}

		if(e.getSource()==Calculadora2.this.botonIgual){
			y= Float.parseFloat(pantalla.getText());

			switch(opcion){
				case 1:
					pantalla.setText("");
					pantalla.setText(String.valueOf(x+y));
					break;
				case 2:
					pantalla.setText("");
					pantalla.setText(String.valueOf(x-y));
					break;
				case 3:
					pantalla.setText("");
					pantalla.setText(String.valueOf(x*y));
					break;
				case 4:
					if(y != 0){
						pantalla.setText("");
						pantalla.setText(String.valueOf(x/y));
					
					}
					else{
						pantalla.setText("Error division por cero");
					}
					break;
				case 5:
					pantalla.setText("");
					pantalla.setText(String.valueOf(Math.pow(x,y)));
					break;
				case 6:
					pantalla.setText("");
					pantalla.setText(String.valueOf(Math.log(x)/Math.log(y)));
					break;
				default:
					pantalla.setText("Ups, opcion incorrecta");					
			}

		}
		if(e.getSource()==Calculadora2.this.estandar){
			botonCuad.setVisible(false);
			botonCubo.setVisible(false);
			botonSeno.setVisible(false);
			botonCos.setVisible(false);
			botonTan.setVisible(false);
			botonAsen.setVisible(false);
			botonAtan.setVisible(false);
			botonAcos.setVisible(false);
			botonConvRad.setVisible(false);
			botonConvGrad.setVisible(false);
			botonRad.setVisible(false);
			botonGrad.setVisible(false);
			botonFac.setVisible(false);
			botonLog.setVisible(false);
			botonLn.setVisible(false);
			botonInv.setVisible(false);
			botonSigno.setVisible(false);
			botonPi.setVisible(false);
			botonRaiz.setVisible(false);
			botonExp.setVisible(false);
			botonPot.setVisible(false);
			this.setBounds(400,100,300,280);
			
		}
		if(e.getSource()==Calculadora2.this.cientifica){
			botonCuad.setVisible(true);
			botonCubo.setVisible(true);
			botonSeno.setVisible(true);
			botonCos.setVisible(true);
			botonTan.setVisible(true);
			botonAsen.setVisible(true);
			botonAtan.setVisible(true);
			botonAcos.setVisible(true);
			botonConvRad.setVisible(true);
			botonConvGrad.setVisible(true);
			botonRad.setVisible(true);
			botonGrad.setVisible(true);
			botonFac.setVisible(true);
			botonLog.setVisible(true);
			botonLn.setVisible(true);
			botonInv.setVisible(true);
			botonSigno.setVisible(true);
			botonPi.setVisible(true);
			botonRaiz.setVisible(true);
			botonExp.setVisible(true);
			botonPot.setVisible(true);
			this.setBounds(400,100,300,350);

		}
		if(e.getSource()==Calculadora2.this.oscuro){
			this.getContentPane().setBackground(Color.BLACK);
			boton9.setBackground(Color.BLACK);
			boton9.setForeground(Color.WHITE);
			boton8.setBackground(Color.BLACK);
			boton8.setForeground(Color.WHITE);
			boton7.setBackground(Color.BLACK);
			boton7.setForeground(Color.WHITE);
			boton6.setBackground(Color.BLACK);
			boton6.setForeground(Color.WHITE);
			boton5.setBackground(Color.BLACK);
			boton5.setForeground(Color.WHITE);
			boton4.setBackground(Color.BLACK);
			boton4.setForeground(Color.WHITE);
			boton3.setBackground(Color.BLACK);
			boton3.setForeground(Color.WHITE);
			boton2.setBackground(Color.BLACK);
			boton2.setForeground(Color.WHITE);
			boton1.setBackground(Color.BLACK);
			boton1.setForeground(Color.WHITE);
			boton0.setBackground(Color.BLACK);
			boton0.setForeground(Color.WHITE);
			botonCuad.setBackground(Color.BLACK);
			botonCuad.setForeground(Color.WHITE);
			botonCubo.setBackground(Color.BLACK);
			botonCubo.setForeground(Color.WHITE);
			botonSeno.setBackground(Color.BLACK);
			botonSeno.setForeground(Color.WHITE);
			botonCos.setBackground(Color.BLACK);
			botonCos.setForeground(Color.WHITE);
			botonTan.setBackground(Color.BLACK);
			botonTan.setForeground(Color.WHITE);
			botonAtan.setBackground(Color.BLACK);
			botonAtan.setForeground(Color.WHITE);
			botonAsen.setBackground(Color.BLACK);
			botonAsen.setForeground(Color.WHITE);
			botonAcos.setBackground(Color.BLACK);
			botonAcos.setForeground(Color.WHITE);
			botonInv.setBackground(Color.BLACK);
			botonInv.setForeground(Color.WHITE);
			botonPot.setBackground(Color.BLACK);
			botonPot.setForeground(Color.WHITE);
			botonPi.setBackground(Color.BLACK);
			botonPi.setForeground(Color.WHITE);
			botonRaiz.setBackground(Color.BLACK);
			botonRaiz.setForeground(Color.WHITE);
			botonConvGrad.setBackground(Color.BLACK);
			botonConvGrad.setForeground(Color.WHITE);
			botonConvRad.setBackground(Color.BLACK);
			botonConvRad.setForeground(Color.WHITE);
			botonFac.setBackground(Color.BLACK);
			botonFac.setForeground(Color.WHITE);
			botonLn.setBackground(Color.BLACK);
			botonLn.setForeground(Color.WHITE);
			botonLog.setBackground(Color.BLACK);
			botonLog.setForeground(Color.WHITE);
			botonExp.setBackground(Color.BLACK);
			botonExp.setForeground(Color.WHITE);
			botonSigno.setBackground(Color.BLACK);
			botonSigno.setForeground(Color.WHITE);
			botonSum.setBackground(Color.BLACK);
			botonSum.setForeground(Color.WHITE);
			botonRetro.setBackground(Color.BLACK);
			botonRetro.setForeground(Color.WHITE);
			botonRes.setBackground(Color.BLACK);
			botonRes.setForeground(Color.WHITE);
			botonMult.setBackground(Color.BLACK);
			botonMult.setForeground(Color.WHITE);
			botonDiv.setBackground(Color.BLACK);
			botonDiv.setForeground(Color.WHITE);
			botonPunto.setBackground(Color.BLACK);
			botonPunto.setForeground(Color.WHITE);
			
		}
		if(e.getSource()==Calculadora2.this.claro){
			this.getContentPane().setBackground(Color.LIGHT_GRAY);
			boton9.setBackground(UIManager.getColor("Button.background"));
			boton9.setForeground(Color.BLACK);
			boton8.setBackground(UIManager.getColor("Button.background"));
			boton8.setForeground(Color.BLACK);
			boton7.setBackground(UIManager.getColor("Button.background"));
			boton7.setForeground(Color.BLACK);
			boton6.setBackground(UIManager.getColor("Button.background"));
			boton6.setForeground(Color.BLACK);
			boton5.setBackground(UIManager.getColor("Button.background"));
			boton5.setForeground(Color.BLACK);
			boton4.setBackground(UIManager.getColor("Button.background"));
			boton4.setForeground(Color.BLACK);
			boton3.setBackground(UIManager.getColor("Button.background"));
			boton3.setForeground(Color.BLACK);
			boton2.setBackground(UIManager.getColor("Button.background"));
			boton2.setForeground(Color.BLACK);
			boton1.setBackground(UIManager.getColor("Button.background"));
			boton1.setForeground(Color.BLACK);
			boton0.setBackground(UIManager.getColor("Button.background"));
			boton0.setForeground(Color.BLACK);
			botonCuad.setBackground(UIManager.getColor("Button.background"));
			botonCuad.setForeground(Color.BLACK);
			botonCubo.setBackground(UIManager.getColor("Button.background"));
			botonCubo.setForeground(Color.BLACK);
			botonSeno.setBackground(UIManager.getColor("Button.background"));
			botonSeno.setForeground(Color.BLACK);
			botonCos.setBackground(UIManager.getColor("Button.background"));
			botonCos.setForeground(Color.BLACK);
			botonTan.setBackground(UIManager.getColor("Button.background"));
			botonTan.setForeground(Color.BLACK);
			botonAtan.setBackground(UIManager.getColor("Button.background"));
			botonAtan.setForeground(Color.BLACK);
			botonAsen.setBackground(UIManager.getColor("Button.background"));
			botonAsen.setForeground(Color.BLACK);
			botonAcos.setBackground(UIManager.getColor("Button.background"));
			botonAcos.setForeground(Color.BLACK);
			botonInv.setBackground(UIManager.getColor("Button.background"));
			botonInv.setForeground(Color.BLACK);
			botonPot.setBackground(UIManager.getColor("Button.background"));
			botonPot.setForeground(Color.BLACK);
			botonPi.setBackground(UIManager.getColor("Button.background"));
			botonPi.setForeground(Color.BLACK);
			botonRaiz.setBackground(UIManager.getColor("Button.background"));
			botonRaiz.setForeground(Color.BLACK);
			botonConvGrad.setBackground(UIManager.getColor("Button.background"));
			botonConvGrad.setForeground(Color.BLACK);
			botonConvRad.setBackground(UIManager.getColor("Button.background"));
			botonConvRad.setForeground(Color.BLACK);
			botonFac.setBackground(UIManager.getColor("Button.background"));
			botonFac.setForeground(Color.BLACK);
			botonLn.setBackground(UIManager.getColor("Button.background"));
			botonLn.setForeground(Color.BLACK);
			botonLog.setBackground(UIManager.getColor("Button.background"));
			botonLog.setForeground(Color.BLACK);
			botonExp.setBackground(UIManager.getColor("Button.background"));
			botonExp.setForeground(Color.BLACK);
			botonSigno.setBackground(UIManager.getColor("Button.background"));
			botonSigno.setForeground(Color.BLACK);
			botonSum.setBackground(UIManager.getColor("Button.background"));
			botonSum.setForeground(Color.BLACK);
			botonRetro.setBackground(UIManager.getColor("Button.background"));
			botonRetro.setForeground(Color.BLACK);
			botonRes.setBackground(UIManager.getColor("Button.background"));
			botonRes.setForeground(Color.BLACK);
			botonMult.setBackground(UIManager.getColor("Button.background"));
			botonMult.setForeground(Color.BLACK);
			botonDiv.setBackground(UIManager.getColor("Button.background"));
			botonDiv.setForeground(Color.BLACK);
			botonPunto.setBackground(UIManager.getColor("Button.background"));
			botonPunto.setForeground(Color.BLACK);

		}
		if(e.getSource()==Calculadora2.this.pantalla_oscura){
			pantalla.setBackground(Color.BLACK);
			pantalla.setForeground(Color.WHITE);
		}
		if(e.getSource()==Calculadora2.this.pantalla_clara){
			pantalla.setBackground(Color.WHITE);
			pantalla.setForeground(Color.BLACK);
		}
		if(e.getSource()==Calculadora2.this.acerca){
			JOptionPane.showMessageDialog(null,"Calculadora Cientifica Algoritmica"+"\n"+" Autor:Flavio Osella"+"\n"+"Córdoba, Argentina");
		}
	}
	public static void main(String[] args) {
		 new Calculadora2("Calculadora2");
	}
};