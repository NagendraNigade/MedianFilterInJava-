# MedianFilterInJava-
Median Filter on Gray Scale Image In Java :

Aim : Reduce the noise of Grayscale image using Median Filter.
Image size taken as 512*512.
The Size of the filter is 3.
Edges are kept unchanged.

Algorithm (MedianFilterGrayScale.java) :

1.1 Read the Imput image into array.
1.2 Creata a temporary array of 3*3 (As the size of filter is 3) to apply filter.
1.3 Sort the Temporary array and store the new median value into new array.
1.4 User WritableRaster to Create new image from pixcel. (Edges are kept unchaged with the same values as of source image)


