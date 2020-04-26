/**
 * 
 */
var ROOT_URL = "/cms-fusion-web/file/browse?cluster=?1&parent=?2&navigateBack=?3";
var pcluster;
function setCluster(cluster)
{
	pcluster = 	cluster;
}
function getCluster()
{
	return pcluster;
}
var targetRef;
function setTarget( targetField)
{
	if(targetField == null || targetField == "")
	{
		targetRef = null;
	}
	else{
	    targetRef = new Object() ;
		targetRef.targetField = targetField;
		// Method name to call once file dialog is finished.
		targetRef.targetFieldObj = eval( targetField ) ;
	}
}

function getTarget()
{
	return targetRef;
}

function getFileChooserSource(aUrl) {
	var source =
    {
        datatype: "json",
        datafields: [
            { name: 'name', type: 'string' },
            { name: 'parentPath', type: 'string' },
			{ name: 'lastModified', type: 'date' },
			{ name: 'fileType', type: 'string' },
			{ name: 'fullPath', type: 'string' },
			{ name: 'backNavigation', type: 'string' },
			{ name: 'size', type: 'number' },
			
        ],                
		sortcolumn: 'fileType',
		sortdirection: 'asc',
		url: aUrl
    };
	return source;
}

function getFileChooserColumns() {
	var columns =  [
											
	                    { text: 'File name', datafield: 'name', width: 310,  align: 'left' ,cellsrenderer : _renderFileLocation },
	                    { text: 'Size', datafield: 'size', width: 100,  align: 'left' ,cellsrenderer : _renderSize},
	                    { text: 'Last Modified', datafield: 'lastModified' ,width: 170 ,  align: 'left' , cellsalign: 'left' ,  columntype: 'datetimeinput',filtertype:'date' , cellsformat: 'MMM d, yyyy HH:mm:ss' },
	                    { text: 'Type', datafield: 'fileType', width: 120 , cellsalign: 'left', align: 'left'  ,cellsrenderer : _renderFileType},
	                    { text: 'Parent', datafield: 'parentPath', width: 210 ,  align: 'left' , cellsalign: 'left', hidden: true},
	                    { text: 'Path', datafield: 'fullPath', width: 155 ,  align: 'center' , cellsalign: 'center', hidden: true,filterable: false,sortable: false, menu: false,  align: 'left' , cellsalign: 'left'},
	                    { text: 'Back Navigation', datafield: 'backNavigation', width: 210 ,  align: 'left' , cellsalign: 'left', hidden: true},
	                ];
	return columns;
}

function loadMeWithRoot(cluster,target)
{
	resetMe('root');	
	$("#locationInput").val('');
	setTarget(target);
	setCluster(cluster);
	$("#file-window").jqxWindow('show');
	loadFileChooser(true);
}

function loadMeForChilds()
{
    var rowindex = $('#file-grid').jqxGrid('getselectedrowindex');
    var data = $('#file-grid').jqxGrid('getrowdatabyid', rowindex);
	var parent = data.fullPath;
	$("#locationInput").val(parent);
	$("#file-window").jqxWindow('show');
	loadFileChooser(false,parent);
}

function loadFileChooser(fromRoot,arg1,arg2)
{
	var aUrl = ROOT_URL.replace('?1',getCluster());
	aUrl = 	fromRoot ? aUrl.replace('?2','') : aUrl.replace('?2',arg1);
	aUrl =  arg2==null ? aUrl.replace('?3','') :aUrl.replace('?3', arg2);
	var dataAdapter = new $.jqx.dataAdapter(getFileChooserSource(aUrl));
    $("#file-grid").jqxGrid(
    {
        width: 700,
        source: dataAdapter,
        columnsresize: true,
		sortable: true,
        filterable: true,
		//altrows: true,		
		showsortcolumnbackground: false,
        columns: getFileChooserColumns(),
        
        showtoolbar: true,
        rendertoolbar: function (statusbar) {
          var container = $("<div style='overflow: hidden; position: relative; margin: 5px;'></div>");
   		  var homeButton = $("<div style='float: right; margin-right: 5px;'><span style='margin-right: 4px; position: relative;'>Home</span></div>");
 		  var backButton = $("<div style='float: right; margin-right: 5px;'><span style='margin-right: 4px; position: relative;'>Back</span></div>");
 		  var titleTemplate = getCluster()!= null && getCluster()!= "" ? $("<span class='gridtitle'>"+ getCluster() +"</span>") : $("<span class='gridtitle'>Unsupported Site</span>");
 		  var locationInput = $("<div style='float: right; margin-right: 5px;'><input type='text' id='locationInput' /></div>");
 		  
 		  container.append(titleTemplate);
   		  container.append(backButton);
   		  container.append(homeButton);
   		  container.append(locationInput);
   		
   		  statusbar.append(container);
	   	 
   		  locationInput.jqxInput({
   		    placeHolder: "Current Location",
   		    height: 25,
   		    width: 300,
   		    //minLength: 1,
   		    source: [],
   		    disabled:true
   		});
   		
   		  homeButton.jqxButton({  width: 65, height: 15 });
   		  backButton.jqxButton({  width: 65, height: 15 });
   		  
   		  // reload grid data.
          homeButton.on("click",function (event) {
              loadMeWithRoot(getCluster(), getTarget().targetField);
            	 
          });
          
          backButton.on("click",function (event) {
        	  var rowindex = $('#file-grid').jqxGrid('getselectedrowindex');
        	  var data = $('#file-grid').jqxGrid('getrowdatabyid', rowindex);
        		
        	  if(data ==null)
              {
        		  loadFileChooser(false,$("#locationInput").val(),"Y");
        	  }else if(data.parentPath!= null && data.parentPath!="" )
              {
            	  $("#locationInput").val(data.backNavigation);
            	  loadFileChooser(false,$("#locationInput").val(),"Y");
              }else{
            	  loadMeWithRoot(getCluster(), getTarget().targetField);
              }
          });
         }
    });
}

function initWindow()
{
	var offset = $("#file-window").offset();
	//$("#file-window").jqxWindow({position: { x: parseInt(offset.left) + 100, y: parseInt(offset.top) -300}, width: 600, height:740,resizable: true,modalOpacity: 0.01, cancelButton: $("#fileCancel"),okButton:$("#fileSave")});
	$("#file-window").jqxWindow({position: { x:  600, y: 200}, width: 800, height:640,resizable: false,modalOpacity: 0.01, cancelButton: $("#fileCancel"),okButton:$("#fileSave"),draggable:true});
}

var _renderFileLocation = function (index, datafield, value, defaultHtml, column, rowdata) 
{
    //rowdata.parentPath
	var html;
	if(rowdata.fileType == 'FILE')
	{
		html= "<div style='display:none;' id=div"+index+">"+rowdata.fullPath +"</div>";
		html+= " <a  href='javascript:void(0);' onClick=readFilePath(\'div"+index+"\'); style='color:black;'>&nbsp;"+value+"</a>";
	}else{
		html= " <a  href='javascript:void(0);' onClick=loadMeForChilds(); style='color:black;'>";
		html+= "<img src='"+$("#resourcelocation").val()+"/images/multi_folder.gif' width='15' height='15' border='0' alt='Dir' />&nbsp;";
		html+=value;
		html+="</a>";
	}
    return "<div style='margin: 6px;' class='jqx-left-align'>" + html + "</div>";        
}

var _renderFileType = function (index, datafield, value, defaultHtml, column, rowdata) 
{
    //rowdata.parentPath
    return "<div style='margin: 6px;' class='jqx-left-align'>" + (value == "DIRECTORY" ? "Dir" : "File") + "</div>";        
}

var _renderSize = function (index, datafield, value, defaultHtml, column, rowdata) 
{
	var size = Number(value);
	var displayText = "";
	var KB = 1024;
	var MB = KB *KB;
	var GB = MB * KB;
	
	if(size/KB < KB)
	{
		displayText = (Number(value)/ KB ).toFixed(2) +" KB";
	}else if(size/KB > KB && size/MB < MB)
	{
		displayText = (Number(value)/ MB ).toFixed(2) +" MB";
	}else{
		displayText =  (Number(value)/ GB ).toFixed(2)+" GB";
	}
	
    return "<div style='margin: 6px;' class='jqx-left-align'>" + (rowdata.fileType == 'FILE'? displayText :"" ) + "</div>";        
}

function resetMe()
{
	setTarget(null);
	$("#locationInput").val('');
	$("#file-grid").jqxGrid('clear');
	 
}

function readFilePath(id)
{
	//Hack for reading a path to avoid jqxGrid internal errors.
	selectMe($("#"+id).text());
}

function selectMe(file)
{
	if(file!=null && file!="")
	{
		getTarget().targetFieldObj.value = file;
	}
	resetMe();
	$("#file-window").jqxWindow('hide');	
}

function initMe()
{
	initWindow();

	$("#fileSave").on("click",function () {
		var rowindex = $('#file-grid').jqxGrid('getselectedrowindex');
  	  	var data = $('#file-grid').jqxGrid('getrowdatabyid', rowindex);
  	  	if(data!=null)
  	  	{
  	  		selectMe(data.fullPath);
  	  	}
	});

	$("#fileCancel").on("click",function () {
		resetMe();
		$("#file-window").jqxWindow('hide');
	});
}

//Initializing Parameters on load
initMe();
