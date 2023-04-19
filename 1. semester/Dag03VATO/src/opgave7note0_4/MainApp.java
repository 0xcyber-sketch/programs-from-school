package opgave7note0_4;

import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.event.*;
import javafx.scene.*;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application
{
   
    @Override
    public void start(Stage stage)
    {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Patrick Star");
        stage.setScene(scene);
        
        
        stage.show();
        
        
     
    }

    private Pane initContent()
    {
        Pane pane = new Pane();
        pane.setPrefSize(600, 623);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane)
    {
    	//Some idea Patrick star more idea
    	Color black = Color.BLACK;
    	Color pink = Color.PINK;
    	Color white = Color.WHITE;
    	
    	
    	
    	//Sides
    	Line l1 = new Line(175,325,218,71);
    	Line l2 = new Line(370,320,296,52);
    	
    	//Top
    	Arc arc1 = new Arc();
    	arc1.setCenterX(260);
    	arc1.setCenterY(136);
    	arc1.setRadiusX(52);
    	arc1.setRadiusY(120);
    	arc1.setStartAngle(45);
    	arc1.setLength(125);
    	arc1.setType(ArcType.OPEN);
    	arc1.setFill(null);
    	arc1.setStroke(black);
    	
    	//Eyes
    	Circle c1 = new Circle(254,144,30);
    	c1.setFill(null);
    	c1.setStroke(black);
    	Circle c2 = new Circle(314,144,30);
    	c2.setFill(white);
    	c2.setStroke(black);
    	Circle c3 = new Circle(257,144,4);
    	c3.setFill(black);
    	Circle c4 = new Circle(317,144,4);
    	c4.setFill(black);
    	
    	//Arm
    	Circle c5 = new Circle(240,360,90);
    	c5.setFill(white);
    	c5.setStroke(black);
    	Circle c6 = new Circle(270,360,100);
    	c6.setFill(white);
    	c6.setStroke(white);
    	Circle c7 = new Circle(234,285,50);
    	c7.setFill(white);
    	c7.setStroke(white);
    	
    	Ellipse e1 = new Ellipse();
    	e1.setCenterX(163);
    	e1.setCenterY(360);
    	e1.setRadiusX(10);
    	e1.setRadiusY(40);
    	e1.setStroke(white);
    	e1.setFill(white);
    	
    	
    	Circle c8 = new Circle(194,402,15);
    	c8.setFill(white);
    	c8.setStroke(white);
    	
    	Circle c9 = new Circle(194,350,42);
    	c9.setFill(white);
    	c9.setStroke(white);
    	
    	Line l3 = new Line(179,405,215,335);
    	
    	
    	
    	//mouth
    	Ellipse topM = new Ellipse();
    	topM.setCenterX(274);
    	topM.setCenterY(293);
    	topM.setRadiusX(55);
    	topM.setRadiusY(80);
    	topM.setStroke(black);
    	topM.setFill(white);
    	
    	Rectangle butM1 = new Rectangle(191,291,260,100);
    	butM1.setStroke(white);
    	butM1.setFill(white);
    	
    	Ellipse butM2 = new Ellipse();
    	butM2.setCenterX(274);
    	butM2.setCenterY(291);
    	butM2.setRadiusX(55);
    	butM2.setRadiusY(5);
    	butM2.setStroke(black);
    	butM2.setFill(white);
    	
    	Ellipse butM3 = new Ellipse();
    	butM3.setCenterX(274);
    	butM3.setCenterY(289);
    	butM3.setRadiusX(55);
    	butM3.setRadiusY(5);
    	butM3.setStroke(white);
    	butM3.setFill(white);
    	
    	
    	
    	
    	//Buttom
    	Circle but1 = new Circle(213, 416,50);
    	but1.setStroke(black);
    	but1.setFill(white);
    	
    	
    	Ellipse but2 = new Ellipse();
    	but2.setCenterX(170);
    	but2.setCenterY(373);
    	but2.setRadiusX(15);
    	but2.setRadiusY(40);
    	but2.setStroke(black);
    	but2.setFill(white);
    	
    	
    	
    	Ellipse but3 = new Ellipse();
    	but3.setCenterX(220);
    	but3.setCenterY(458);
    	but3.setRadiusX(30);
    	but3.setRadiusY(10);
    	but3.setStroke(black);
    	but3.setFill(white);
    	
    	
    	Ellipse but4 = new Ellipse();
    	but4.setCenterX(220);
    	but4.setCenterY(456);
    	but4.setRadiusX(32);
    	but4.setRadiusY(10);
    	but4.setStroke(white);
    	but4.setFill(white);
    	
    	Line l4 = new Line(206,467,320, 492);
    	
    	Circle c10 = new Circle(240,417,55);
    	c10.setStroke(white);
    	c10.setFill(white);
    	
    	//foot one 
    	Ellipse foot1 = new Ellipse();
    	foot1.setCenterX(488);
    	foot1.setCenterY(450);
    	foot1.setRadiusX(22);
    	foot1.setRadiusY(30);
    	foot1.setStroke(black);
    	foot1.setFill(white);
    	foot1.getTransforms().add(new Rotate(105,400,400)); //Ain't easy fam 
    	
    	Ellipse foot1_02 = new Ellipse();
    	foot1_02.setCenterX(487);
    	foot1_02.setCenterY(454);
    	foot1_02.setRadiusX(22);
    	foot1_02.setRadiusY(28);
    	foot1_02.setStroke(white);
    	foot1_02.setFill(white);
    	foot1_02.getTransforms().add(new Rotate(105,400,400));
    	
    	Circle c11 = new Circle(340,444,15);
    	c11.setFill(white);
    	c11.setStroke(white);
    	
    	Line l5 = new Line(298,429, 348,457);
    	
    	Circle c17 = new Circle(320,460,15);
    	c17.setFill(white);
    	c17.setStroke(white);
    	
    	Circle c18 = new Circle(294,460,15);
    	c18.setFill(white);
    	c18.setStroke(white);
    	
    	Circle c19 = new Circle(270,460,15);
    	c19.setFill(white);
    	c19.setStroke(white);
    	
    	
    	// Belly 
    	
    	Circle c12 = new Circle(300,375,80);
    	c12.setFill(white);
    	c12.setStroke(black);
    	
    	Rectangle rec_01 = new Rectangle(222,297,140,90);
    	rec_01.setFill(white);
    	rec_01.setStroke(white);
    	
    	Rectangle rec_02 = new Rectangle(210,348,60,118);
    	rec_02.setFill(white);
    	rec_02.setStroke(white);
    	
    	
    	//Arm 2 
    	Ellipse arm2 = new Ellipse();
    	arm2.setCenterX(370);
    	arm2.setCenterY(319);
    	arm2.setRadiusX(15);
    	arm2.setRadiusY(30);
    	arm2.setStroke(black);
    	arm2.setFill(null);
    	arm2.getTransforms().add(new Rotate(-15,362,324));
    	
    	Circle c13 = new Circle(359,349,15);
    	c13.setFill(white);
    	c13.setStroke(white);
    	
    	Circle c14 = new Circle(345,330,15);
    	c14.setFill(white);
    	c14.setStroke(white);
    	
    	Circle c15 = new Circle(345,310,20);
    	c15.setFill(white);
    	c15.setStroke(white);
    	
    	Circle c16 = new Circle(350,290,10);
    	c16.setFill(white);
    	c16.setStroke(white);
    	
    	// leg 2
    	
    	Line l6 = new Line(343,444,389,454);
    	
    	Ellipse leg2_01 = new Ellipse();
    	leg2_01.setCenterX(400);
    	leg2_01.setCenterY(440);
    	leg2_01.setRadiusX(28);
    	leg2_01.setRadiusY(17);
    	leg2_01.setStroke(black);
    	leg2_01.setFill(white);
    	leg2_01.getTransforms().add(new Rotate(17,400,440));
    	
    	Line l7 = new Line(350,395,405,424);
    	
    	Circle c20 = new Circle(390,438,14);
    	c20.setFill(white);
    	c20.setStroke(white);
    	
    	Circle c21 = new Circle(390,434,15);
    	c21.setFill(white);
    	c21.setStroke(white);
    	
    	Circle c22 = new Circle(358,425,21);
    	c22.setFill(white);
    	c22.setStroke(white);
    	
    	Circle c23 = new Circle(380,436,15);
    	c23.setFill(white);
    	c23.setStroke(white);
    	
    	Circle c24 = new Circle(380,429,15);
    	c24.setFill(white);
    	c24.setStroke(white);
    	
    	
    	//Pants
    	Ellipse pleg2_01 = new Ellipse();
    	pleg2_01.setCenterX(397);
    	pleg2_01.setCenterY(412);
    	pleg2_01.setRadiusX(22);
    	pleg2_01.setRadiusY(14);
    	pleg2_01.setStroke(black);
    	pleg2_01.setFill(null);
    	pleg2_01.getTransforms().add(new Rotate(-66,400,440));
    	
    	Ellipse pleg1_01 = new Ellipse();
    	pleg1_01.setCenterX(300);
    	pleg1_01.setCenterY(460);
    	pleg1_01.setRadiusX(27);
    	pleg1_01.setRadiusY(10);
    	pleg1_01.setStroke(black);
    	pleg1_01.setFill(null);
    	pleg1_01.getTransforms().add(new Rotate(-68,300,460));
    	
    	Circle c25 = new Circle(313,462,20);
    	c25.setFill(white);
    	c25.setStroke(white);
    	
    	Circle c26 = new Circle(311,455,15);
    	c26.setFill(white);
    	c26.setStroke(white);
    	
    	Circle c27 = new Circle(303,471,15);
    	c27.setFill(white);
    	c27.setStroke(white);
    	
    	Ellipse ptop_01 = new Ellipse();
    	ptop_01.setCenterX(300);
    	ptop_01.setCenterY(399);
    	ptop_01.setRadiusX(130);
    	ptop_01.setRadiusY(50);
    	ptop_01.setStroke(black);
    	ptop_01.setFill(null);
    	ptop_01.getTransforms().add(new Rotate(-21,300,430));
    	
    	Ellipse ptop_02 = new Ellipse();
    	ptop_02.setCenterX(300);
    	ptop_02.setCenterY(405);
    	ptop_02.setRadiusX(130);
    	ptop_02.setRadiusY(50);
    	ptop_02.setStroke(black);
    	ptop_02.setFill(null);
    	ptop_02.getTransforms().add(new Rotate(-21,300,430));
    	
    	//Fill
    	Circle c28 = new Circle(157,451,15);
    	c28.setFill(white);
    	c28.setStroke(white);
    	Circle c29 = new Circle(175,471,15);
    	c29.setFill(white);
    	c29.setStroke(white);
    	Circle c30 = new Circle(173,469,15);
    	c30.setFill(white);
    	c30.setStroke(white);
    	Circle c31 = new Circle(183,476,15);
    	c31.setFill(white);
    	c31.setStroke(white);
    	Circle c32 = new Circle(203,484,15);
    	c32.setFill(white);
    	c32.setStroke(white);
    	Circle c33 = new Circle(217,486,15);
    	c33.setFill(white);
    	c33.setStroke(white);
    	Circle c34 = new Circle(234,457,15);
    	c34.setFill(white);
    	c34.setStroke(white);
    	Circle c35 = new Circle(220,454,15);
    	c35.setFill(white);
    	c35.setStroke(white);
    	Circle c36 = new Circle(250,461,15);
    	c36.setFill(white);
    	c36.setStroke(white);
    	Circle c37 = new Circle(307,460,15);
    	c37.setFill(white);
    	c37.setStroke(white);
    	Circle c38 = new Circle(275,455,15);
    	c38.setFill(white);
    	c38.setStroke(white);
    	Circle c39 = new Circle(320,460,15);
    	c39.setFill(white);
    	c39.setStroke(white);
    	Circle c40 = new Circle(310,457,15);
    	c40.setFill(white);
    	c40.setStroke(white);
    	Circle c41 = new Circle(393,399,15);
    	c41.setFill(white);
    	c41.setStroke(white);
    	Circle c42 = new Circle(397,347,15);
    	c42.setFill(white);
    	c42.setStroke(white);
    	Circle c43 = new Circle(375,330,6);
    	c43.setFill(white);
    	c43.setStroke(white);
    	Circle c44 = new Circle(378,332,6);
    	c44.setFill(white);
    	c44.setStroke(white);
    	Circle c45 = new Circle(377,336,6);
    	c45.setFill(white);
    	c45.setStroke(white);
    	Circle c46 = new Circle(380,429,15);
    	c46.setFill(white);
    	c46.setStroke(white);
    	Circle c47 = new Circle(376,430,15);
    	c47.setFill(white);
    	c47.setStroke(white);
    	Circle c48 = new Circle(346,418,14);
    	c48.setFill(white);
    	c48.setStroke(white);
    	Circle c49 = new Circle(346,422,14);
    	c49.setFill(white);
    	c49.setStroke(white);
    	Circle c50 = new Circle(332,440,6);
    	c50.setFill(white);
    	c50.setStroke(white);
    	Circle c51 = new Circle(325,436,6);
    	c51.setFill(white);
    	c51.setStroke(white);
    	Circle c52 = new Circle(319,449,6);
    	c52.setFill(white);
    	c52.setStroke(white);
    	Circle c53 = new Circle(340,436,6);
    	c53.setFill(white);
    	c53.setStroke(white);
    	Circle c54 = new Circle(403,370,20);
    	c54.setFill(white);
    	c54.setStroke(white);
    	Circle c55 = new Circle(220,310,15);
    	c55.setFill(white);
    	c55.setStroke(white);
    	Circle c56 = new Circle(252,281,12);
    	c56.setFill(white);
    	c56.setStroke(white);
    	Circle c57 = new Circle(252,283,12);
    	c57.setFill(white);
    	c57.setStroke(white);
    	Circle c58 = new Circle(268,287,8);
    	c58.setFill(white);
    	c58.setStroke(white);
    	Circle c59 = new Circle(350,400,20);
    	c59.setFill(white);
    	c59.setStroke(white);
    	
    	
    	
    	//Tonuge
    	Ellipse t01 = new Ellipse();
    	t01.setCenterX(245);
    	t01.setCenterY(303);
    	t01.setRadiusX(27);
    	t01.setRadiusY(38);
    	t01.setStroke(black);
    	t01.setFill(null);
    	//t01.getTransforms().add(new Rotate(-21,300,430));
    	
    	Ellipse t02 = new Ellipse();
    	t02.setCenterX(274);
    	t02.setCenterY(307);
    	t02.setRadiusX(27);
    	t02.setRadiusY(38);
    	t02.setStroke(black);
    	t02.setFill(null);
    	    	
    	//Pattern
    	Circle c60 = new Circle(300,390,20);
    	c60.setFill(null);
    	c60.setStroke(black);
    	
    	Circle c61 = new Circle(325,363,17);
    	c61.setFill(null);
    	c61.setStroke(black);
    	
    	Circle c62 = new Circle(263,383,17);
    	c62.setFill(null);
    	c62.setStroke(black);
    	
    	Circle c63 = new Circle(276,376,14);
    	c63.setFill(white);
    	c63.setStroke(white);
    	
    	Circle c64 = new Circle(310,365,14);
    	c64.setFill(white);
    	c64.setStroke(white);
    	
    	Circle c65 = new Circle(315,362,14);
    	c65.setFill(white);
    	c65.setStroke(white);
    	
    	Circle c66 = new Circle(270,378,14);
    	c66.setFill(white);
    	c66.setStroke(white);
    	
    	Circle c67 = new Circle(290,378,14);
    	c67.setFill(white);
    	c67.setStroke(white);
    	
    	
    	Circle c68 = new Circle(261,470,25);
    	c68.setFill(null);
    	c68.setStroke(black);
    	
    	Circle c69 = new Circle(283,481,2);
    	c69.setFill(white);
    	
    	
    	Circle c70 = new Circle(283,479,2);
    	c70.setFill(white);
    	
    	Circle c71 = new Circle(284,477,2);
    	c71.setFill(white);
    	
    	Circle c72 = new Circle(280,450,12);
    	c72.setFill(null);
    	c72.setStroke(black);
    	
    	Circle c73 = new Circle(280,496,12);
    	c73.setFill(white);
    	c73.setStroke(white);
    	
    	Circle c74 = new Circle(235,487,12);
    	c74.setFill(white);
    	c74.setStroke(white);
    	
    	Circle c75 = new Circle(275,458,12);
    	c75.setFill(white);
    	c75.setStroke(white);
    	
    	Circle c76 = new Circle(248,500,20);
    	c76.setFill(white);
    	c76.setStroke(white);
    	
    	Circle c77 = new Circle(370,414,12);
    	c77.setFill(null);
    	c77.setStroke(black);
    	
    	Circle c78 = new Circle(379,400,8);
    	c78.setFill(null);
    	c78.setStroke(black);
    	
    	Circle c79 = new Circle(371,405,2);
    	c79.setFill(white);
    	
    	Circle c80 = new Circle(373,402,2);
    	c80.setFill(white);
    	
    	Circle c81 = new Circle(378,404,2);
    	c81.setFill(white);
    	
    	Circle c82 = new Circle(379,407,2);
    	c82.setFill(white);
    	
    	Circle c83 = new Circle(382,408,2);
    	c83.setFill(white);
    	
    	Circle c84 = new Circle(379,430,15);
    	c84.setFill(white);
    	
    	Circle c85 = new Circle(382,416,3);
    	c85.setFill(white);
    	
    	Circle c86 = new Circle(373,430,12);
    	c86.setFill(white);
    	
    	Circle c87 = new Circle(392,393,13);
    	c87.setFill(white);
    	
    	Circle c88 = new Circle(392,400,13);
    	c88.setFill(white);

    	
    	pane.getChildren().addAll(
   l1,l2,arc1,c1,c2,c3,c4,c5,c6,c7,topM,butM1,butM2,butM3,but1,but2,t01,
   t02,e1,c8, c9, l3, but3, but4, l4,foot1,c10, foot1_02,c11,c12, l5, rec_01, arm2,c13,c14,c15,c16,rec_02,c17,c18,c19,
l6,leg2_01,l7,c20,c21,c22,pleg2_01,c23,c24, pleg1_01, c25,c26,c27, ptop_01, ptop_02, c28, c29,c30,c31, c32,c33,c34,
c35,c36, c37, c38, c39,c40, c41, c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58,c59, c60, c61, c62,
c63,c64,c65,c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78, c79, c80, c81, c82, c83, c84, c85, c86, c87,
c88
);
   	
        
    }
}
