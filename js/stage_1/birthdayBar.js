function birthday(s, d, m) {
  let counter=0, sum=0;
  for(let i=0; i<=s.length-m;i++){
      for(let j=i,x=1;x<=m;x++,j++){
          sum+=s[j];
      }
      if(sum==d){
          counter++;   
      }
      sum=0;
  }
  
return counter;

}