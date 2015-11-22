# MedianFilterInJava-
Median Filter on Gray Scale Image In Java :

Aim : Reduce the noise of Grayscale image using Median Filter.
Image size taken as 512*512.
The Size of the filter is 3.
Edges are kept unchanged.

How Median Filter works :

Median For Pixel at (1,1)

155(0,0) 158(0,1) 159(0,2)
136(1,0) 124(1,1) 126(1,2)
154(2,0) 158(2,1) 159(2,2)

Sort : 124 126 136 154 155 158 158 159 159
Replace the value of 124 by 155 (New Value by median)

Algorithm (MedianFilterGrayScale.java) :

1.1 Read the Imput image into array.
1.2 Creata a temporary array of 3*3 (As the size of filter is 3) to apply filter.
1.3 Sort the Temporary array and store the new median value into new array.
1.4 User WritableRaster to Create new image from pixcel. (Edges are kept unchaged with the same values as of source image)


