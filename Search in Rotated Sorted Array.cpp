class Solution {
public:
    int search(vector<int>& a, int target) 
    {
      int i,l=0,r=a.size()-1,mid;
      while(l<=r)
      {
          mid=(l+r)/2;
          if(a[mid]==target)
          return mid;
          else if(a[l]<=a[mid])
          {
              if(target>=a[l]&&target<a[mid])
              r=mid-1;
              else
              l=mid+1;
          }
          else
          {
              if(target>=a[mid]&&target<=a[r])
              l=mid+1;
              else
              r=mid-1;
          }
      }
      return-1;

    }
};