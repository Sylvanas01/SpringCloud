/**
 * bootstrap-table封装
 * 参数一览，没有得自行添加
 * DEFAULTS = {
        classes: 'table table-hover',
        sortClass: undefined,
        locale: undefined,
        height: undefined,
        undefinedText: '-',
        sortName: undefined,
        sortOrder: 'asc',
        sortStable: false,
        striped: false,
        columns: [[]],
        data: [],
        totalField: 'total',
        dataField: 'rows',
        method: 'get',
        url: undefined,
        ajax: undefined,
        cache: true,
        contentType: 'application/json',
        dataType: 'json',
        ajaxOptions: {},
        queryParams: function (params) {
            return params;
        },
        queryParamsType: 'limit', // undefined
        responseHandler: function (res) {
            return res;
        },
        pagination: false,
        onlyInfoPagination: false,
        paginationLoop: true,
        sidePagination: 'client', // client or server
        totalRows: 0, // server side need to set
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 25, 50, 100],
        paginationHAlign: 'right', //right, left
        paginationVAlign: 'bottom', //bottom, top, both
        paginationDetailHAlign: 'left', //right, left
        paginationPreText: '&lsaquo;',
        paginationNextText: '&rsaquo;',
        search: false,
        searchOnEnterKey: false,
        strictSearch: false,
        searchAlign: 'right',
        selectItemName: 'btSelectItem',
        showHeader: true,
        showFooter: false,
        showColumns: false,
        showPaginationSwitch: false,
        showRefresh: false,
        showToggle: false,
        buttonsAlign: 'right',
        smartDisplay: true,
        escape: false,
        minimumCountColumns: 1,
        idField: undefined,
        uniqueId: undefined,
        cardView: false,
        detailView: false,
        detailFormatter: function (index, row) {
            return '';
        },
        trimOnSearch: true,
        clickToSelect: false,
        singleSelect: false,
        toolbar: undefined,
        toolbarAlign: 'left',
        checkboxHeader: true,
        sortable: true,
        silentSort: true,
        maintainSelected: false,
        searchTimeOut: 500,
        searchText: '',
        iconSize: undefined,
        buttonsClass: 'default',
        iconsPrefix: 'glyphicon', // glyphicon of fa (font awesome)
        icons: {
            paginationSwitchDown: 'glyphicon-collapse-down icon-chevron-down',
            paginationSwitchUp: 'glyphicon-collapse-up icon-chevron-up',
            refresh: 'glyphicon-refresh icon-refresh',
            toggle: 'glyphicon-list-alt icon-list-alt',
            columns: 'glyphicon-th icon-th',
            detailOpen: 'glyphicon-plus icon-plus',
            detailClose: 'glyphicon-minus icon-minus'
        },

        customSearch: $.noop,

        customSort: $.noop,

        rowStyle: function (row, index) {
            return {};
        },

        rowAttributes: function (row, index) {
            return {};
        },

        footerStyle: function (row, index) {
            return {};
        },

        onAll: function (name, args) {
            return false;
        },
        onClickCell: function (field, value, row, $element) {
            return false;
        },
        onDblClickCell: function (field, value, row, $element) {
            return false;
        },
        onClickRow: function (item, $element) {
            return false;
        },
        onDblClickRow: function (item, $element) {
            return false;
        },
        onSort: function (name, order) {
            return false;
        },
        onCheck: function (row) {
            return false;
        },
        onUncheck: function (row) {
            return false;
        },
        onCheckAll: function (rows) {
            return false;
        },
        onUncheckAll: function (rows) {
            return false;
        },
        onCheckSome: function (rows) {
            return false;
        },
        onUncheckSome: function (rows) {
            return false;
        },
        onLoadSuccess: function (data) {
            return false;
        },
        onLoadError: function (status) {
            return false;
        },
        onColumnSwitch: function (field, checked) {
            return false;
        },
        onPageChange: function (number, size) {
            return false;
        },
        onSearch: function (text) {
            return false;
        },
        onToggle: function (cardView) {
            return false;
        },
        onPreBody: function (data) {
            return false;
        },
        onPostBody: function () {
            return false;
        },
        onPostHeader: function () {
            return false;
        },
        onExpandRow: function (index, row, $detail) {
            return false;
        },
        onCollapseRow: function (index, row) {
            return false;
        },
        onRefreshOptions: function (options) {
            return false;
        },
        onRefresh: function (params) {
          return false;
        },
        onResetView: function () {
            return false;
        }
 */
function $bootTable(target,opt){//target:table得id
	$(target).bootstrapTable({
		 url:opt.url?opt.url:undefined,
		 method:opt.method?opt.method:'post',
		 cache:opt.cache?opt.cache:true,
		 dataType:opt.dataType?opt.dataType:'json',
		 contentType:opt.contentType?opt.contentType:'application/x-www-form-urlencoded',
		 toolbar:opt.toolbar?opt.toolbar:undefined,
		 classes:"table table-hover table-striped",
		 pagination:opt.pagination?opt.pagination:true,
		 sidePagination:opt.sidePagination?opt.sidePagination:'server',	//client客户端分页:返回list，server服务端分页: 返回数据需包含total和rows两个参数
		 //searchTimeOut:10000,
		 search:opt.search?opt.search:true,
		 searchText:opt.searchText?opt.searchText:'',
		 showRefresh:opt.showRefresh?opt.showRefresh:true,
		 //searchOnEnterKey:true,
		 showToggle:opt.showToggle?opt.showToggle:true,			//显示table和card切换			 
		 //cardView:false,			//true为card视图,false为table视图		 
		 singleSelect:opt.singleSelect?opt.singleSelect:true,
		 showPaginationSwitch: true,
		 searchAlign:opt.searchAlign?opt.searchAlign:'right',
		 selectItemName:opt.selectItemName?opt.selectItemName:'btSelectItem',
		 idField:opt.idField?opt.idField:undefined,
		 pageNumber:opt.pageNumber?opt.pageNumber:1,
		 pageSize:opt.pageSize?opt.pageSize:10,
		 pageList:opt.pageList?opt.pageList:[5,10,15,20],
		 clickToSelect:opt.clickToSelect?opt.clickToSelect:false,
		 onCheck:opt.onCheck?opt.onCheck:function(row){		
		 },
		 queryParamsType:opt.queryParamsType?opt.queryParamsType:undefined,	//设置为limit可以获取limit, offset, search, sort, order, 设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
		 queryParams:opt.queryParams?opt.queryParams:function(params){	//分页查询参数
			 return params;
		 },
		 columns:opt.columns?opt.columns:[[]],
		 onLoadSuccess:opt.onLoadSuccess?opt.onLoadSuccess:function(data){	//成功时执行		
		 },
		 onLoadError:opt.onLoadError?opt.onLoadError:function(data){	//失败时执行		 
		 }
	 });
}