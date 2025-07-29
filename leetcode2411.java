class Solution {
    public int[] smallestSubarrays(int[] nums) {
        // if(nums.length==1)return new int[]{1};
         int m1=Integer.MIN_VALUE;
        for(int ele:nums)
        {
          m1=Math.max(ele,m1);
        }
        int[] a=new int[nums.length];
        if(m1==0)
        {
          Arrays.fill(a,1);
          return a;
        }
        int m=(int)(Math.log(m1)/Math.log(2))+1;
        System.out.println(m);
        int[] ans=new int[m];
        Arrays.fill(ans,nums.length);
         
        for(int i=nums.length-1;i>=0;i--)
        {   int max=i;
            for(int j=0;j<m;j++)
            {
                int mask=1<<j;
                if((nums[i]& mask)!=0)ans[j]=i;
                else if(ans[j]!=nums.length) max=Math.max(max,ans[j]);
            }
            
            
            a[i]=max-i+1;
        }
       return a;
    }
}
// class Solution {
//   public int[] smallestSubarrays(int[] nums) {
//     final int MAX_BIT = 30;
//     int[] ans = new int[nums.length];
//     // closest[j] := the closest index i s.t. the j-th bit of nums[i] is 1
//     int[] closest = new int[MAX_BIT];

//     Arrays.fill(ans, 1);

//     for (int i = nums.length - 1; i >= 0; --i)
//       for (int j = 0; j < MAX_BIT; ++j) {
//         if ((nums[i] >> j & 1) == 1)
//           closest[j] = i;
//         ans[i] = Math.max(ans[i], closest[j] - i + 1);
//       }

//     return ans;
//   }
// }