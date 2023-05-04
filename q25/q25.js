loop1:
for(i=0; i<5; i++){
    document.write("i="+i+" ");
    loop2:
    for(j=0; j<5; j++){
        if(i==3&&j==3){
            document.write("<br>");
            continue loop1;
        }
        else if(i==1&&j==1){
            document.write("<br>");
            continue loop1;
        }
        else
            document.write("☆");
    }
    document.write("<br>");
}