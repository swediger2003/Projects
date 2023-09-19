Overall, the code that we received was very well written and well documented. Every requirement for 
the Image Processor was met and we did not have to request that any changes needed to be made to the
code. On a high level, their code was easily extensible and understandable.

The interfaces we were given were very flexible. The most flexible was the features interface that 
they used which contained three very high level methods, doAction, exitProgram, and commandSelect, 
which allows their controller to be used for more than just this specific imageprocessor but for any
sort program which would require a list of commands. Their controller interface also only has one 
function, playGame(), which is very indicative of what their controller would be used for. Their 
model controllers were more specific to the actual implementation of the code. However, the split 
between the ModelState and just the Model interface was well thought out for security reasons as 
the ModelState interface only contains observer methods and nothing that could alter the code. 
Their view was not as flexible either as it was a GUI specific view, however it was not tightly 
coupled with Swing library and can be used to implement other GUI views that need Histograms and 
use a Features interface. One thing to note is that there were some interfaces that seemed to have
been “replaced” with an abstract class, such as their AFunction class. I would also recommend adding
a Command interface with the method execute(ImageModel m).

As everything in their implementation works, some strengths of their code were the following. The 
code was easily extensible as the only thing necessary in order to make a new function object was 
to extend the abstract class (AFunction) which abstracted over the two for loops and had an abstract
do something method which would represent the change to each individual pixel. This reduced a lot of
code duplication as the loops are used in every command. Nothing in the model would need to be 
altered in order to create a new operation. A new command object would need to be created. Also, 
for security purposes, the separation between the ImageModelState and the ImageModel was very
well-thought-out.

Some limitations to their code that we found include a limitation of their command pattern 
abstraction, and some other limitations in the GUI that hinder the user experience (in our opinion).
The abstraction, which although is well thought out, becomes a little obsolete when creating 
operations like Mosaic require reference to a field that it only created once, such as a random 
list of positions. This meant that we had to override the given abstraction in my Mosaic object so 
that we could create that list. As for the user experience, the condition of no spaces in the 
filepath was very inconvenient, especially when first using their GUI. We believe the reason for 
this is due to their text based interaction between the GUIView and the controller. Also, the 
GUIView starts out very small on the first popup and must be expanded every time. Increasing the 
size of the main panel might be a good idea. Also making the command panel portrait instead of 
landscape may also make it easier on the user. Lastly, there are many classes in the Model which 
can make things a little difficult to understand, for clarity’s sake. Some of the function objects 
could have been abstracted such as Brighten/Darken, Blur/Sharpen,  or Horizontal/Vertical Flip. 
The grayscales could also have been abstracted with a simple switch statement in a utils class.