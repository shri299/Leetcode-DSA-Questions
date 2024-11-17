class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startPixelColor = image[sr][sc];

        if(startPixelColor!=color){
            dfs(image,sr,sc,startPixelColor,color);
        }

        return image;
    }

    public void dfs(int[][] image, int x, int y, int startPixelColor, int color){
        if(x<0 || y<0 || x>=image.length || y>=image[0].length){
            return;
        }
        if(image[x][y]!=startPixelColor || image[x][y]==color){
            return;
        }
        image[x][y] = color;

        dfs(image,x-1,y,startPixelColor,color);
        dfs(image,x+1,y,startPixelColor,color);
        dfs(image,x,y+1,startPixelColor,color);
        dfs(image,x,y-1,startPixelColor,color);
    }
}