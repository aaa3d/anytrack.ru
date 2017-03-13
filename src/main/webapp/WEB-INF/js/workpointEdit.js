/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



        function myformatter(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            var h = date.getHours();
            var M = date.getMinutes();
            return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(M<10?('0'+M):M);
        }
        

        function myparser(s){

            if (!s) return new Date();
            var dt = s.split(' ');
            
            var ss = dt[0].split('-');
            var y = parseInt(ss[0],10);
            var m = parseInt(ss[1],10);
            var d = parseInt(ss[2],10);
            
            
            var tt = dt[1].split(':');
            var h = parseInt(tt[0],10);
            var M = parseInt(tt[1],10);
            
            if (!isNaN(y) && !isNaN(m) && !isNaN(d) && !isNaN(h) && !isNaN(M)){
                return new Date(y,m-1,d, h, M)
            } else {
                return new Date();
            }
        }
