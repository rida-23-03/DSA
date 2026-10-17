class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length; //rows
        int n=matrix[0].length; //cols
        boolean firstrow=false;
        boolean firstcol=false;

        //check if first row has zeros
        for(int j=0;j<n;j++){ 
            if(matrix[0][j]==0){ //0 is 1st row j cols
                firstrow=true;
                break;
            }
        }
        //check if first cols has zeros
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                firstcol=true;
                break;
            }
        }
        //then start from next row and col if zero there update in the first ro and cols instead of newrow and col array takes more space 
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0; //first col
                    matrix[0][j]=0; //first row
                }
            }
        }
        //then set the other things of same row or col to 0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //if first row had zero set it to zero
        if(firstrow){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        //if first col had zero then set it to zero
        if(firstcol){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }

    }
}