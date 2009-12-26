//Comment out the following package statement to compile separately.
//package com.javaworld.media.j3d;

import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Example01 extends Frame {
/**
* Instantiates an Example01 object.
**/
	public static void main(String args[]) {
		new Example01();
	}

	/**
	* The Example01 constructor sets the frame's size, adds the
	* visual components, and then makes them visible to the user.
	*
	* We place a Canvas3D object into the Frame so that Java 3D
	* has the heavyweight component it needs to render 3D
	* graphics into.  We then call methods to construct the
	* View and Content branches of our scene graph.
	**/
	public Example01() {
		//Title our frame and set its size.
		super("Java 3D Example01");
		setSize(400,300); 

		//Here is our first Java 3D-specific code.  We add a
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
		//both a view branch and a content branch.  In order to
		//actually use our view branch, we also need to construct
		//a View and connect it to our view branch's ViewPlatform.
		View myView = constructView(myCanvas3D);
		Locale myLocale = constructViewBranch(myView);
		constructContentBranch(myLocale);
	}

	/**
	* constructView() takes a Canvas3D reference and constructs
	* a View to display in that Canvas3D.  It uses the default
	* PhysicalBody and PhysicalEnvironment (both required to be
	* set or else the 3D runtime will throw exceptions).  The
	* returned View is used by constructViewBranch() to attach
	* the scene graph's ViewPlatform to a Canvas3D for rendering.
	*
	* @see constructViewBranch(View)
	**/
	private View constructView(Canvas3D myCanvas3D) {
		View myView = new View();
		myView.addCanvas3D(myCanvas3D);
		myView.setPhysicalBody(new PhysicalBody());
		myView.setPhysicalEnvironment(new PhysicalEnvironment());
		return(myView);
	}


		/**
		* constructViewBranch() takes as input a View which we
		* attached to our Canvas3D in constructView().  It constructs
		* a default view branch for the scene graph, attaches
		* the View to the ViewPlatform, and returns a reference to
		* our Locale for use by constructContentBranch()
		* in creating content for our scene graph.
		*
		* @see constructView(Canvas3D)
		* @see constructContentBranch(Locale)
		**/
	private Locale constructViewBranch(View myView) {

		//First, we create the necessary coordinate systems 
		//(VirtualUniverse, Locale), container nodes
		//(BranchGroup, TransformGroup), and platform which 
		//determines our viewing position and direction (ViewPlatform).  
		VirtualUniverse myUniverse = new VirtualUniverse();
		Locale myLocale = new Locale(myUniverse);
		BranchGroup myBranchGroup = new BranchGroup();
		TransformGroup myTransformGroup = new TransformGroup();
		ViewPlatform myViewPlatform = new ViewPlatform();

		//Next, we insert the platform into the transform group, 
		//the transform group into the branch group, and the branch
		//group into the locale's branch graph portion of the 
		//scene graph.
		myTransformGroup.addChild(myViewPlatform);
		myBranchGroup.addChild(myTransformGroup);
		myLocale.addBranchGraph(myBranchGroup);

		//Finally, we attach our view to the view platform and we
		//return a reference to our new universe.  We are ready to 
		//render 3D content!
		myView.attachViewPlatform(myViewPlatform);
		return(myLocale);
	}

	/**
	* constructContentBranch() is where we specify the 3D graphics
	* content to be rendered into the VirtualUniverse referenced
	* in the passed parameter.  As an example, let's render a
	* some three dimensional text:  We render the word "JavaWorld"
	* in Times Roman font, extruded, then translated, scaled, and
	* rotated off of the original coordinate axes.
	*
	* Compare to Java 2D example com.javaworld.media.j2d.Example04: 
	* http://www.javaworld.com/javaworld/jw-07-1998/jw-07-media.html 
	*
	* @see constructViewBranch(View)
	**/
	private void constructContentBranch(Locale myLocale) {
		//We first create a regular 2D font, then from that a
		//3D font, 3D text, and 3D shape, in succession.  We use
		//the default constructors for FontExtrusion and Appearance.
		Font myFont = new Font("TimesRoman",Font.PLAIN,10);
		Font3D myFont3D = new Font3D(myFont,new FontExtrusion());
		Text3D myText3D = new Text3D(myFont3D, "JavaWorld");
		Shape3D myShape3D = new Shape3D(myText3D, new Appearance());   

		//We created a new branch group and transform group to hold
		//our content.  This time when we create the transform group,
		//however, we pass in a Transform3D to the transform group's
		//constructor.  This 3D transform has been manipulated
		//to perform the transformations we desire, which results
		//in those manipulations being carried out on all children
		//of the given transform group, in this case, our content.
		BranchGroup contentBranchGroup = new BranchGroup();
		Transform3D myTransform3D = new Transform3D();
		myTransform3D.setTranslation(new Vector3f(-1.0f,0.0f,-4.0f));
		myTransform3D.setScale(0.1);
		Transform3D tempTransform3D = new Transform3D();
		tempTransform3D.rotY(Math.PI/4.0d);
		myTransform3D.mul(tempTransform3D);
		TransformGroup contentTransformGroup = new TransformGroup(myTransform3D);

		//We add our child nodes and insert the branch group into
		//the live scene graph.  This results in Java 3D rendering
		//the content.
		contentTransformGroup.addChild(myShape3D);
		contentBranchGroup.addChild(contentTransformGroup);
		myLocale.addBranchGraph(contentBranchGroup);
	}

}
