/**
 * 时间日期相关操作
 */


/**
 * 时间格式化
 * 将 2018-09-23T11:54:16.000+0000 格式化成 2018/09/23 11:54:16
 * @param datetime 国际化日期格式
 */
export function format (datetime) {
  return formatWithSeperator(datetime, "-", ":");
}

/**
 * 时间格式化
 * 将 2018-09-23T11:54:16.000+0000 格式化成类似 2018/09/23 11:54:16
 * 可以指定日期和时间分隔符
 * @param datetime 国际化日期格式
 */
export function formatWithSeperator (datetime, dateSeprator, timeSeprator) {
  if (datetime != null) {
    const dateMat = new Date(datetime);
    const year = dateMat.getFullYear();
    const month = dateMat.getMonth() + 1;
    const day = dateMat.getDate();
    const hh = dateMat.getHours();
    const mm = dateMat.getMinutes();
    const ss = dateMat.getSeconds();
    const timeFormat = year + dateSeprator + month + dateSeprator + day + " " + hh + timeSeprator + mm + timeSeprator + ss;
    return timeFormat;
  }
}


/**
 * 时间格式化
 * 将 2018/09/23 11:54:16 格式化成 2018-09-23T11:54:16.000+0000
 * @param datetime 国际化日期格式
 */
export function formatout (datetime) {
  return formatWithSeperatorout(datetime, "-", ":","T");
}

/**
 * 时间格式化
 * 将 2018/09/23 11:54:16 格式化成类似 2018-09-23T11:54:16.000+0000
 * 可以指定日期和时间分隔符
 * @param datetime 国际化日期格式
 */
export function formatWithSeperatorout (datetime, dateSeprator, timeSeprator,linkSeprator) {
  if (datetime != null) {
    var dateMat = new Date(datetime);
    dateMat.setTime(dateMat.getTime()-8*60*60*1000);
    const year = dateMat.getFullYear();
    var month = dateMat.getMonth() + 1;
    if(month.toString().length!=2){
      month = "0" + month;
    }
    var day = dateMat.getDate();
    if(day.toString().length!=2){
      day = "0" + day;
    }
    var hh = dateMat.getHours();
    if(hh.toString().length!=2){
      hh = "0" + hh;
    }
    var mm = dateMat.getMinutes();
    if(mm.toString().length!=2){
      mm = "0" + mm;
    }
    var ss = dateMat.getSeconds();
    if(ss.toString().length!=2){
      ss = "0" + ss;
    }
    const timeFormat = year + dateSeprator + month + dateSeprator + day + linkSeprator + hh + timeSeprator + mm + timeSeprator + ss + ".000+0000";
    return timeFormat;
  }
}