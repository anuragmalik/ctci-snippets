
public class MergeTwoSortedArrays {    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length -1;
        int m = nums2.length -1;
        return medianFinder(nums1, 0, n, nums2, 0, m);
    }
    
    public double medianFinder(int[] one, int s1,int e1, int[] two,int s2, int e2) {
        
        int lenOne = (e1-s1)+1;
        int lenTwo = (e2-s2)+1;
        int midOne = lenOne / 2;
        int midTwo = lenTwo / 2;
        //int midOne = (s1 + e1)/ 2;
        //int midTwo = (s2 + e2)/ 2;
        
        if (lenOne <= 0) {
            if(lenTwo == 0)
                return 0;
            else if(lenTwo % 2 == 0)
                return (double) (two[midTwo] + two[midTwo-1])/2;
            else
                return two[midTwo]; 
        }
        if (lenTwo <= 0) {
            if(lenOne == 0)
                return 0;
            else if(lenOne % 2 == 0)
                return (double) (one[midOne] + one[midOne-1])/2;
            else
                return one[midOne]; 
        }
        
        if (one[midOne] == two[midTwo])
            return one[midOne];
            
        if (lenOne == 1 && lenTwo == 1)
            return (double) (one[s1] + two[s2])/2;
        if(lenOne == 1) {
            int med = two[midTwo];
            if (lenTwo % 2 == 0)
                med += two[midTwo-1] / 2; 
            return (double) (one[midOne] + med) / 2; 
        }
        
        if(lenTwo == 1) {
            int med = one[midOne];
            if (lenOne % 2 == 0)
                med += one[midOne-1] / 2; 
            return (double) (two[midTwo] + med) / 2; 
        }
        
        if(lenTwo == 1) {
            
        }
        if(lenOne == 2 && lenTwo == 2) {
            return (double) (Math.max(one[s1], two[s2]) + Math.min(one[e1], two[e2]))/2; }
        
        if (one[midOne] > two[midTwo]) {
            return medianFinder(one, s1, midOne, two, midTwo, e2); 
        }   else {
            return medianFinder(one, midOne, e1, two, s2, midTwo);
        }
    }
}


