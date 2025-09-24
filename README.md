# Project ConicSectionGrapher in Java
Create a Java program that draws the conic graph of the general equation:  

**a₁₁x² + 2a₁₂xy + a₂₂y² + 2a₁₃x + 2a₂₃y + a₃₃ = 0**

The program will have the following graphical interface:

1. A window containing 3 panels, objects of type Panels class (from the Buffon program).  
2. The first panel will contain 6 text boxes (objects of the TextField class), preceded by the texts: "a11:", "a12:", etc., and a button (object of the Button class). In these 6 text boxes, the user will input the values for the coefficients a11, a12, a22, a13, a23, and a33. The button will have the label "Draw", and when pressed, if no exceptions are thrown, the conic will be drawn in the third panel.  
3. The second panel will be used to display the properties of the conic (the type of the conic, the center, the values of the determinants, etc.). It will have the same dimensions as the first panel.  
4. The third panel will be used to display the conic. The coordinate axes will be drawn first in black, then the center of the conic and its axes of symmetry will be drawn in blue, and finally, the conic itself will be drawn in red.

Below are some example images showcasing the different types of conic sections that the application can generate. These include hyperbolas, ellipses, and parabolas, each plotted based on the general conic equation:  
**a₁₁x² + 2a₁₂xy + a₂₂y² + 2a₁₃x + 2a₂₃y + a₃₃ = 0**    
The images illustrate how the application accurately renders conic sections, whether the coefficients are all nonzero or some of them are zero. By adjusting these coefficients, users can explore the variety of conic shapes that can be formed.  

Theorem 1. (Isometric classification theorem of conics) The orthogonal and centro-orthogonal invariants of a conic allow determining the nature of the conic as in the table in the following image (Requirement 2):  
![image](https://github.com/user-attachments/assets/3e7bd373-bc69-4a28-95bf-9eb82e002358)  


![Alt text](images/hiperbole1.png)
![Alt text](images/hiperbole2.png)  
![Alt text](images/elipsa.png)  
![Alt text](images/elipsa2.png)  
![Alt text](images/parabola.png)  
