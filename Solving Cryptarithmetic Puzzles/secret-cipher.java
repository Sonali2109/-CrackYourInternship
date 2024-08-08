class Solution {
    
    long binpow(long a, long b)
    {
        long MOD = 1000000007;
        long ans = 1;
        while(b>0)
        {
            if((b&1)!=0)
            {
                ans = (ans*a)%MOD;
            }
            
            a = (a*a)%MOD;
            b>>=1;
        }
        
        return ans;
    }
    
	public String compress(String s) {
		// Your code goes  here
		long p = 31;
		int n = s.length();
		long MOD = 1000000007;
		
		long hash[] = new long[n+1];
		long ppow[] = new long[n+1];
		long inv[] = new long[n+1];
		
		Arrays.fill(ppow, 1);
		Arrays.fill(inv, 1);
		
		for(int i=1; i<=n; i++)
		{
		    ppow[i] = (ppow[i-1]*p)%MOD;
		    inv[i] = binpow(ppow[i], MOD-2);
		}
		
		
		for(int i=0; i<n; i++)
		{
		    hash[i+1] = (s.charAt(i)-'a'+1)*ppow[i];
		    hash[i+1] %= MOD;
		    hash[i+1] = (hash[i]+hash[i+1])%MOD;
		}
		
		StringBuilder ans = new StringBuilder();
		int i = n;
		
		while(i>=1)
		{
		    if((i&1)!=0)
		    {
		        ans.append(s.charAt(--i));
		        continue;
		    }
		    
		    int m = i/2;
		    long val1 = hash[m];
		    long val2 = (hash[i]-hash[m]+MOD)%MOD;
		    val2 = (val2*inv[m])%MOD;
		    if(val1==val2)
		    {
		        ans.append('*');
		        i=m;
		    }
		    else
		    {
		        ans.append(s.charAt(--i));
		    }
		}
		
		ans.reverse();
		
		return ans.toString();
		
		
	}
}
