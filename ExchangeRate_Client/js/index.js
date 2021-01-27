
class Currency {
    constructor() {
      this.initData();
      this.initEvent();
    }

    initData(){
        this.type = 1;

        this.currencyinfos = [];
        this.fromCur = "VND";
        this.toCur = "USD";
        this.fromMoney = 0;
        this.moneyExchange = 0;

        this.currPage = 0;
        this.maxPage = 0;

        this.row = 15;
        this.datafilter = "";
        this.currencyinfosFilter = [];
    }

    initEvent(){
        $(".button-first-page").click(this.gotoFirstPage);
        $(".button-prev-page").click(this.gotoPrevPage);
        $(".button-next-page").click(this.gotoNexPage);
        $(".button-last-page").click(this.gotoLastPage);
        $(".input-filter").keyup(this.filterData);
        $(".button-form").click(this.getResultExchangeRate)
    }

    getAllCurrency(){
        $.ajax({
            url: "http://localhost:8080/currency/getAll",
            method: "GET",
            dataType: "json",
            contentType: "application/json",
            success: function(data) {
                let selectFrom = $("select[name='fromCur']");
                let selectTo = $("select[name='toCur']");
                let input = $("input[name='fromMoney']");
                let input2 = $("input[name='moneyExchange']");
                if(data != null){
                    selectFrom.html("");
                    selectTo.html("");
                    input.val(0);
                    input2.val(0);
                    data.forEach(curr => {
                        let textFrom = "<option value='{0}' {1}>{2} - {3}</option>";
                        let textTo = "<option value='{0}' {1}>{2} - {3}</option>";

                        textFrom = textFrom.replace("{0}", curr.sumName)
                        if(curr.sumName == currencyObject.fromCur){
                            textFrom = textFrom.replace("{1}","selected");
                        }else{
                            textFrom = textFrom.replace("{1}","");
                        }

                        textFrom = textFrom.replace("{2}",curr.sumName);
                        textFrom = textFrom.replace("{3}",curr.curName);

                        textTo = textTo.replace("{0}", curr.sumName)
                        if(curr.sumName == currencyObject.toCur){
                            textTo = textTo.replace("{1}","selected");
                        }else{
                            textTo = textTo.replace("{1}","");
                        }

                        textTo = textTo.replace("{2}",curr.sumName);
                        textTo = textTo.replace("{3}",curr.curName);

                        selectFrom.append(textFrom);
                        selectTo.append(textTo);
                    });
                }
            },
            error: function(xhr, ajaxOptions, thrownError) {
                message.showError(xhr + " " + ajaxOptions + " " + thrownError, function() {});
                event.stopImmediatePropagation();
            }
        });
    }

    getResultExchangeRate(){
        let dataForm = {};
        if(currencyObject.type == 0){
            currencyObject.fromMoney = $("input[name='fromMoney']").val();
            currencyObject.fromCur = $("select[name='fromCur']").val();
            currencyObject.toCur = $("select[name='toCur']").val();
        }else{
            currencyObject.type = 0;
        }
        dataForm.fromCur = currencyObject.fromCur;
        dataForm.toCur = currencyObject.toCur;
        dataForm.fromMoney = currencyObject.fromMoney;
        $.ajax({
            url: "http://localhost:8080/currency/exchange",
            method: "POST",
            dataType: "json",
            data: JSON.stringify(dataForm),
            contentType: "application/json",
            success: function(data) {
                if(data == null){
                    alert("error data");
                }else{
                    currencyObject.fromCur = data.fromCur;
                    currencyObject.toCur = data.toCur;
                    currencyObject.fromMoney = data.fromMoney;
                    currencyObject.moneyExchange = data.moneyExchange;
                    currencyObject.currencyinfos = data.otherCurrencies;

                    let selectFrom = $("select[name='fromCur']");
                    let selectTo = $("select[name='toCur']");
                    let input = $("input[name='fromMoney']");
                    let input2 = $("input[name='moneyExchange']");

                    selectFrom.val(currencyObject.fromCur);
                    selectTo.val(currencyObject.toCur);
                    input.val(currencyObject.fromMoney);
                    input2.val(currencyObject.moneyExchange);

                    currencyObject.fromMoney = 0;
                    currencyObject.datafilter = "";
                    currencyObject.currPage = 1;
                    currencyObject.setMaxPage(currencyObject.currencyinfos);

                    currencyObject.showDataCommon(currencyObject.currencyinfos);
                    currencyObject.showData(currencyObject.currencyinfos);
                }
            },
            error: function(xhr, ajaxOptions, thrownError) {
                alert(xhr + " " + ajaxOptions + " " + thrownError);
                event.stopImmediatePropagation();
            }
        })
    }
    showData(data) {
        if(data != null){
            $(".input-page").val(currencyObject.currPage);
            console.log(currencyObject.maxPage);
            $("#maxPage").html(currencyObject.maxPage);
            let table = $(".table-currency-content tbody");
            table.html("");
            let index = 0;
            let currPage = currencyObject.currPage - 1;
            let start = currPage*currencyObject.row;
            for(let i = 0;i<currencyObject.row;i++){
                if(start + i < data.length){
                    let el = data[start + i];
                    let text = "<tr class='{0}'>\
                                <td class='col-text-center width-70'>{1}</td>\
                                <td class='col-text-center width-100'>{2}</td>\
                                <td class='col-text-center width-100'>{3}</td>\
                                <td class='col-text-left width-300'>{4}</td>\
                                <td class='col-text-left width-400'>{5}</td>\
                                <td class='col-text-right width-250'>{6}</td>\
                                <td class='col-text-right width-200'>{7}</td>\
                            </tr>";
                    if(index % 2 == 0){
                        text = text.replace("{0}","row-bold");
                    }else{
                        text = text.replace("{0}","");
                    }
                    text = text.replace("{1}",el.id);
                    text = text.replace("{2}",el.sumName);
                    if(el.numberCode == null){
                        text = text.replace("{3}","");
                    }else{
                        text = text.replace("{3}",el.numberCode);
                    }
                    text = text.replace("{4}",el.curName);
                    text = text.replace("{5}",el.nation);
                    text = text.replace("{6}",el.exchangeRate);
                    text = text.replace("{7}",el.moneyExchange);
                    table.append(text);
                    index++;
                }
            }
        }
    }

    showDataCommon(data) {
        if(data != null){
            let table = $(".table-currency-common-content tbody");
            table.html("");
            let index = 0;
            data.forEach(el =>{
                if(el.ranking == 3){
                    let text = "<tr class='{0}'>\
                                <td class='col-text-center width-70'>{1}</td>\
                                <td class='col-text-center width-100'>{2}</td>\
                                <td class='col-text-center width-100'>{3}</td>\
                                <td class='col-text-left width-300'>{4}</td>\
                                <td class='col-text-left width-400'>{5}</td>\
                                <td class='col-text-right width-250'>{6}</td>\
                                <td class='col-text-right width-200'>{7}</td>\
                            </tr>";
                    if(index % 2 == 0){
                        text = text.replace("{0}","row-bold");
                    }else{
                        text = text.replace("{0}","");
                    }
                    text = text.replace("{1}",el.id);
                    text = text.replace("{2}",el.sumName);
                    if(el.numberCode == null){
                        text = text.replace("{3}","");
                    }else{
                        text = text.replace("{3}",el.numberCode);
                    }
                    text = text.replace("{4}",el.curName);
                    text = text.replace("{5}",el.nation);
                    text = text.replace("{6}",el.exchangeRate);
                    text = text.replace("{7}",el.moneyExchange);
                    table.append(text);
                    index++;
                }
            });
        }
    }

    filterData(){
        currencyObject.datafilter = $(".input-filter").val();
        let fil = currencyObject.datafilter.toUpperCase();
        console.log(fil);
        let dataShow = currencyObject.currencyinfos.filter(data =>{
            return data.sumName.toUpperCase().indexOf(fil)>=0 | data.curName.toUpperCase().indexOf(fil)>=0 | data.nation.toUpperCase().indexOf(fil)>=0;
        });
        
        currencyObject.setMaxPage(dataShow);
        currencyObject.currPage = 1;
        
        currencyObject.currencyinfosFilter = dataShow;
        currencyObject.showData(currencyObject.currencyinfosFilter);
    }

    gotoFirstPage(){
        if(currencyObject.currPage>1){
            currencyObject.currPage = 1;
            let dataShow = new Array();
            if(currencyObject.datafilter == ""){
                dataShow = currencyObject.currencyinfos;
            }else{
                dataShow = currencyObject.currencyinfosFilter;
            }
            currencyObject.showData(dataShow);
        }
    }

    gotoPrevPage(){
        if(currencyObject.currPage>1){
            currencyObject.currPage --;
            let dataShow = new Array();
            if(currencyObject.datafilter == ""){
                dataShow = currencyObject.currencyinfos;
            }else{
                dataShow = currencyObject.currencyinfosFilter;
            }
            currencyObject.showData(dataShow);
        }
    }

    gotoNexPage(){
        if(currencyObject.currPage<currencyObject.maxPage){
            currencyObject.currPage ++;
            let dataShow = new Array();
            if(currencyObject.datafilter == ""){
                dataShow = currencyObject.currencyinfos;
            }else{
                dataShow = currencyObject.currencyinfosFilter;
            }
            currencyObject.showData(dataShow);
        }
    }

    gotoLastPage(){
        if(currencyObject.currPage<currencyObject.maxPage){
            currencyObject.currPage = currencyObject.maxPage;
            let dataShow = new Array();
            if(currencyObject.datafilter == ""){
                dataShow = currencyObject.currencyinfos;
            }else{
                dataShow = currencyObject.currencyinfosFilter;
            }
            currencyObject.showData(dataShow);
        }
    }

    setMaxPage(data){
        let count = data.length;
        if(count%currencyObject.row == 0){
            currencyObject.maxPage = count/currencyObject.row;
        }else{
            currencyObject.maxPage = Math.floor(count/currencyObject.row) + 1;
        }
    }
  }

  var currencyObject = new Currency();
  $(document).ready(function() {
        currencyObject.getAllCurrency();
        currencyObject.getResultExchangeRate();
  })
  