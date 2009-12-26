//Comment out the following package statement to compile separately.
//package com.javaworld.media.j3d;

/**
 * Example03 illustrates how to take advantage of some of the
 * utilities offered in Sun's non-standard Java 3D packages.
 * <P>
 * This example is designed so that we can swap out the
 * content of our constructView(), constructViewBranch(),
 * and constructContentBranch() methods to change our physical
 * viewing parameters, view branch portion of our scene graph,
 * or content portion of the scene graph independently from each
 * other.
 * <P>
 * This version is compliant with Java 1.2 Beta 4 and
 * Java 3D 1.1 Beta 2, Nov 1998.  Please refer to: <BR>
 * http://www.javaworld.com/javaworld/jw-12-1998/jw-12-media.html
 * <P>
 * @author Bill Day <bill.day@javaworld.com>
 * @version 1.0
 * @see com.javaworld.media.j3d.Example02
 * @see com.sun.j3d.utils.geometry.ColorCube
 * @see com.sun.j3d.utils.universe.SimpleUniverse
**/

import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;

public class Example03 extends Frame {
	/**
	* Instantiates an Example03 object.
	**/
	public static void main(String args[]) {
		new Example03();
	}

	/**
	* The Example03 constructor sets the frame's size, adds the
	* visual components, and then makes them visible to the user.
	* <P>
	* We place a Canvas3D object into the Frame so that Java 3D
	* has the heavyweight component it needs to render 3D
	* graphics into.  We then call methods to construct the
	* View and Content branches of our scene graph.
	**/
	public Example03() {
		//Title our frame and set its size.
		super("Java 3D Example03");
		setSize(400,300); 

		//Here is our first Java 3d-specific code.  We add a
		//Canvas3D to our Frame so that we can render our 3D
		//graphics.  Java 3D requires a heavyweight component
		//Canvas3D into which to render.
		Canvas3D myCanvas3D = new Canvas3D(null);
		add("Center",myCanvas3D);

		//Turn on the visibility of our frame.
		setVisible(true);

		//We want to be sure we properly dispose of resources 
		//this frame is using when the window is closed.  We use 
		//an anonymous inner class adapter for this.
		addWindowListener(new WindowAdapter() 
			{public void windowClosing(WindowEvent e) 
				{dispose(); System.exit(0);}  
			}
		);

		//Now that we have our Frame and Canvas3D, we are ready
		//to start building our scene graph.  We need to construct
		//both a view branch and a content branch.  Using Sun's
		//SimpleUniverse utility, we can combine the View and
		//view branch construction into one simple step.
		SimpleUniverse myUniverse = new SimpleUniverse(myCanvas3D);
		BranchGroup contentBranchGroup = constructContentBranch();
		myUniverse.addBranchGraph(contentBranchGroup);
	}

	/**
	* constructContentBranch() is where we specify the 3D graphics
	* content to be rendered.  We return the content branch group
	* for use with our SimpleUniverse.  We also demonstrate the
	* use of com.sun.j3d.utils.geometry.ColorCube to build more
	* complicated 3D shapes.
	*
	**/
	private BranchGroup constructContentBranch() {
		// content Branch && Transform Group
		BranchGroup contentBranchGroup = new BranchGroup();
		Transform3D myTransform3D = new Transform3D();

		myTransform3D.setTranslation(new Vector3f(-1.0f,0.0f,-4.0f));
		myTransform3D.setScale(0.1);
		Transform3D tempTransform3D = new Transform3D();
		tempTransform3D.rotY(Math.PI/4.0d);
		myTransform3D.mul(tempTransform3D);

		// 3dtext
		Font myFont = new Font("TimesRoman",Font.PLAIN,10);
		Font3D myFont3D = new Font3D(myFont,new FontExtrusion());
		Text3D myText3D = new Text3D(myFont3D, "Arf! Arf! Gotcha!");
		Shape3D myShape3D = new Shape3D(myText3D, new Appearance());   
		TransformGroup contentTransformGroup = new TransformGroup(myTransform3D);

		contentTransformGroup.addChild(myShape3D);
		contentBranchGroup.addChild(contentTransformGroup);
		// end 3dtext

		// cube
		Shape3D myCube = new ColorCube();

		myTransform3D.setIdentity();
		myTransform3D.setTranslation(new Vector3f(-0.5f,-0.5f,-2.3f));
		myTransform3D.setScale(0.1);
		TransformGroup cubeTransformGroup = new TransformGroup(myTransform3D);

		cubeTransformGroup.addChild(myCube);
		contentBranchGroup.addChild(cubeTransformGroup);
		// end cube


		// sphere
		Sphere mySphere = new Sphere(0.5f);

		myTransform3D.setIdentity();
		myTransform3D.setTranslation(new Vector3f(-0.5f,-0.5f,-2.3f));
		myTransform3D.setScale(0.3);
		TransformGroup sphereTransformGroup = new TransformGroup(myTransform3D);

		sphereTransformGroup.addChild(mySphere);
		contentBranchGroup.addChild(sphereTransformGroup);


		return(contentBranchGroup);
	}
}
