class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min=Arrays.stream(ranks).min().getAsInt();

        long l=1, r=1l*min*cars*cars, ans=1;

        while(l<=r){
            long mid = l+(r-l)/2;

            //how many cars can be repaired under mid minutes
            long cars_repaired = calculate(ranks,mid);

            if(cars_repaired>=cars){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return ans;

    }
    long calculate(int a[],long time){
        //ranks * cars * cars = time
        //cars * cars = time/ranks
        //cars = (time/ranks)^0.5

        long cars=0;

        for(int r:a){
            cars += Math.pow(time/r,0.5);
        }

        return cars;
    }
}