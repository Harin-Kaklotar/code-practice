The other day I was listening to National Public Radio's Car Talk, a popular weekly broadcast during which callers ask questions about their vehicles. Before every program break, the show's hosts ask callers to dial 1-800-CAR-TALK, which corresponds to 1-800-227-8255. Of course, the former proves much easier to remember than the latter, in part because the words "CAR TALK" are a composite: two words that represent seven digits. Humans generally find it easier to deal with composites, rather than their individual components. Likewise, when you develop object-oriented software, it's often convenient to manipulate composites just like you manipulate individual components. That premise represents the fundamental principle of the Composite design pattern, the topic of this Java Design Patterns installment.

The Composite pattern

Before we dive into the Composite pattern, I must first define composite objects: objects that contain other objects; for example, a drawing may be composed of graphic primitives, such as lines, circles, rectangles, text, and so on.

Java developers need the Composite pattern because we often must manipulate composites exactly the same way we manipulate primitive objects. For example, graphic primitives such as lines or text must be drawn, moved, and resized. But we also want to perform the same operation on composites, such as drawings, that are composed of those primitives. Ideally, we'd like to perform operations on both primitive objects and composites in exactly the same manner, without distinguishing between the two. If we must distinguish between primitive objects and composites to perform the same operations on those two types of objects, our code would become more complex and more difficult to implement, maintain, and extend.

In Design Patterns, the authors describe the Composite pattern like this:

Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
Implementing the Composite pattern is easy. Composite classes extend a base class that represents primitive objects. Figure 1 shows a class diagram that illustrates the Composite pattern's structure.


Figure 1. A Composite pattern class diagram
In Figure 1's class diagram, I used class names from Design Pattern's Composite pattern discussion: Component represents a base class (or possibly an interface) for primitive objects, and Composite represents a composite class. For example, the Component class might represent a base class for graphic primitives, whereas the Composite class might represent a Drawing class. Figure 1's Leaf class represents a concrete primitive object; for example, a Line class or a Text class. The Operation1() and Operation2() methods represent domain-specific methods implemented by both the Component and Composite classes.

The Composite class maintains a collection of components. Typically, Composite methods are implemented by iterating over that collection and invoking the appropriate method for each Component in the collection. For example, a Drawing class might implement its draw() method like this:

// This method is a Composite method
public void draw() {
   // Iterate over the components
   for(int i=0; i < getComponentCount(); ++i) {
      // Obtain a reference to the component and invoke its draw method
      Component component = getComponent(i);
      component.draw();
   }
}
For every method implemented in the Component class, the Composite class implements a method with the same signature that iterates over the composite's components, as illustrated by the draw() method listed above.

The Composite class extends the Component class, so you can pass a composite to a method that expects a component; for example, consider the following method:

// This method is implemented in a class that's unrelated to the
// Component and Composite classes
public void repaint(Component component) {
   // The component can be a composite, but since it extends
   // the Component class, this method need not
   //  distinguish between components and composites
   component.draw();
}
The preceding method is passed a component—either a simple component or a composit—then it invokes that component's draw() method. Because the Composite class extends Component, the repaint() method need not distinguish between components and composites—it simply invokes the draw() method for the component (or composite).

Figure 1's Composite pattern class diagram does illustrate one problem with the pattern: you must distinguish between components and composites when you reference a Component, and you must invoke a composite-specific method, such as addComponent(). You typically fulfill that requirement by adding a method, such as isComposite(), to the Component class. That method returns false for components and is overridden in the Composite class to return true. Additionally, you must also cast the Component reference to a Composite instance, like this:

...
if(component.isComposite()) {
   Composite composite = (Composite)component;
   composite.addComponent(someComponentThatCouldBeAComposite);
}
...
Notice that the addComponent() method is passed a Component reference, which can be either a primitive component or a composite. Because that component can be a composite, you can compose components into a tree structure, as indicated by the aforementioned quote from Design Patterns.

Figure 2 shows an alternative Composite pattern implementation.


Figure 2. An alternative Composite pattern class diagram
If you implement Figure 2's Composite pattern, you don't ever have to distinguish between components and composites, and you don't have to cast a Component reference to a Composite instance. So the code fragment listed above reduces to a single line:

...
component.addComponent(someComponentThatCouldBeAComposite);
...
But, if the Component reference in the preceding code fragment does not refer to a Composite, what should the addComponent() do? That's a major point of contention with Figure 2's Composite pattern implementation. Because primitive components do not contain other components, adding a component to another component makes no sense, so the Component.addComponent() method can either fail silently or throw an exception. Typically, adding a component to another primitive component is considered an error, so throwing an exception is perhaps the best course of action.

So which Composite pattern implementation—the one in Figure 1 or the one in Figure 2—works best? That's always a topic of great debate among Composite pattern implementers; Design Patterns prefers the Figure 2 implementation because you never need to distinguish between components and containers, and you never need to perform a cast. Personally, I prefer Figure 1's implementation, because I have a strong aversion to implementing methods in a class that don't make sense for that object type.

Now that you understand the Composite pattern and how you can implement it, let's examine a Composite pattern example with the Apache Struts JavaServer Pages (JSP) framework.

