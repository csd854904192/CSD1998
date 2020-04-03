package com.shar.sharingspring.controller;


import com.google.gson.Gson;
import com.shar.sharingspring.aoplog.Log;
import com.shar.sharingspring.javabean.*;
import com.shar.sharingspring.service.UserService;
import com.shar.sharingspring.util.ResponseUtils;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private ResponseUtils responseUtils = new ResponseUtils();
    @Autowired
    private UserService userService;

    /**
     * 管理员端页面跳转
     * @param url
     * @return
     */
    @RequestMapping("path/{url}")
    public String MatchUrl(@PathVariable("url")String url){
        return "/back/jsp/" + url;
    }
//    工程名/WEB-INF/

    /**
     * 用户端页面跳转
     * @param url
     * @return
     */
    @RequestMapping("fPath/{url}")
    public String FMatchUrl(@PathVariable("url")String url){
        return "/front/jsp/" + url;
    }

    /**
     * 显示导航页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        System.out.println("打开页面");
        return modelAndView;
    }

    /**
     * 用户登录
     * @param username
     * @param userpwd
     * @param httpSession
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/frontLogin")
    @ResponseBody
//    @Log(operationType = "登录操作", operationName = "用户登录")
    public String UserLogin(String username, String userpwd, HttpSession httpSession,
                            HttpServletRequest req, HttpServletResponse resp){
        Map<String, String> parameters=new HashMap<>();
        parameters.put("username",username);
        parameters.put("userpwd",userpwd);
        User user = userService.userLogin(parameters);
        if (user.getUsername().equals(username)){
            System.out.println(username + ","+userpwd);
            Menu menu = new Menu();
            menu.setRoleid(user.getRole().getRoleid());
            Map<String, List<Menu>> menuMap = userService.findMenus(menu);
            httpSession.setAttribute("menuMap",menuMap);
            httpSession.setAttribute("user",user);
            return "success";
        }else{
            return "error";
        }
    }

    /**
     * 管理员登录
     * @param username
     * @param userpwd
     * @param httpSession
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/backLogin")
    @ResponseBody
//    @Log(operationType = "登录操作", operationName = "用户登录")
    public void userLogin(String username, String userpwd, HttpSession httpSession,
                            HttpServletRequest req, HttpServletResponse resp)throws IOException{
        Map<String, String> parameters=new HashMap<>();
        parameters.put("username",username);
        parameters.put("userpwd",userpwd);
        User user = userService.userLogin(parameters);
        if (user.getUsername().equals(username)){
            System.out.println(username + ","+userpwd);
            Menu menu = new Menu();
            menu.setRoleid(user.getRole().getRoleid());
            Map<String, List<Menu>> menuMap = userService.findMenus(menu);
            httpSession.setAttribute("menuMap",menuMap);
            httpSession.setAttribute("user",user);
           resp.getWriter().print("success");
        }else{
            resp.getWriter().print("error");
        }
    }

    /**
     * 查询用户
     * @param req
     * @param resp
     */
    @RequestMapping("/findUserInfo")
    @ResponseBody
    public void findUserInfo(HttpServletRequest req, HttpServletResponse resp){
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String username = req.getParameter("username");
        int pageInt = Integer.valueOf(page);
        int limitInt = Integer.parseInt(limit);
        HashMap<String,Object> condition = new HashMap<>();
        if (null!=username&&!"".equals((username.trim()))){
            condition.put("username",username);
        }
        int pageInts = (pageInt-1)*limitInt;
        condition.put("pageInts",pageInts);
        condition.put("limitInt",limitInt);
        Map map = userService.datagrid(condition);
        DatagridResult datagridResult = new DatagridResult();
        if (map.size() != 0){
            datagridResult.setCode(0);
            datagridResult.setMsg("");
            datagridResult.setCount((Integer) map.get("count"));
            datagridResult.setData((List<User>) map.get("users"));
            ResponseUtils.outJson(resp,datagridResult);
        }
    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/updateForm")
    @ResponseBody
    public void updateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Integer userid = Integer.valueOf(request.getParameter("userid"));
             String username = request.getParameter("username");
             String userpwd = request.getParameter("userpwd");
             String occupation = request.getParameter("occupation");
             String degree = request.getParameter("degree");
             String userphone = request.getParameter("userphone");
             String usersex = request.getParameter("usersex");
             String email = request.getParameter("email");
             User user = new User();
             user.setUserid(userid);user.setUsername(username);user.setUserpwd(userpwd);user.setOccupation(occupation);
             user.setDegree(degree);user.setUserphone(userphone);user.setUsersex(usersex);user.setEmail(email);
             int i = userService.updateForm(user);
             if (i>0){
                 response.getWriter().println(1111);
             }else{
                 response.getWriter().println("error");
             }
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
            Integer userid = Integer.valueOf(request.getParameter("userid"));
            int i = userService.deleteUser(userid);
            if (i>0){
               response.getWriter().println(1111);
            }else{
               response.getWriter().println("error");
            }
    }

    /**
     * 退出
     * @param httpSession
     * @return
     */
    @RequestMapping("/Exit")
    public String Exit(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "back/jsp/userLogin";
    }
    @RequestMapping("/findRole")
    public void findRole(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        List<Role> rlist = userService.findRole();
        DatagridResult datagridResult = new DatagridResult();
        if (rlist.size() != 0){
            datagridResult.setCode(0);
            datagridResult.setMsg("");
            datagridResult.setCount(10);
            datagridResult.setData(rlist);
            ResponseUtils.outJson(response,datagridResult);
        }
    }

    /**
     * 查询角色权限
     * @param request
     * @param response
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/findTree")
    public void findTree(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Integer roleid = Integer.valueOf(request.getParameter("roleid"));
        List<TreeResult> flist = userService.findAllFMenu();
        List<TreeResult> clist = userService.findAllRMenu(roleid);
        Map map = new HashMap();
        map.put("menufid",flist);
        map.put("menucid",clist);
        ResponseUtils.outJson(response,map);
    }
    @RequestMapping("/subUpdateMenu")
    public void subUpdateMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String checkedData = request.getParameter("checkedData");
        Integer roleid = Integer.valueOf(request.getParameter("roleid"));
        Gson g = new Gson();
        List<Menurela>mlist = new ArrayList<>();
        TreeResult[] treeResult = g.fromJson(checkedData,TreeResult[].class);
        for(int i=0;i<treeResult.length;i++){
            Menurela menurela = new Menurela();
            menurela.setMenuid(treeResult[i].getId());
            menurela.setRoleid(roleid);
            mlist.add(menurela);
            for(int k=0;k<treeResult[i].getChildren().size();k++){
                Menurela menurela1 = new Menurela();
                menurela1.setMenuid(treeResult[i].getChildren().get(k).getId());
                menurela1.setRoleid(roleid);
                mlist.add(menurela1);
            }
        }
        Map map = new HashMap();
        map.put("roleid",roleid);
        map.put("mlist",mlist);
        boolean flag = userService.subUpdateMenu(map);
            if (flag){
                response.getWriter().print("success");
            }else{
                response.getWriter().print("error");
            }
    }
    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/RegUser")
    public String RegUser(User user){
        if (null != user){
            int i = userService.regUser(user);
            if (i>0){
                return "back/jsp/userLogin";
            }else{
                return "back/jsp/lower";
            }
        }else{
            return "back/jsp/lower";
        }
    }

    /**
     * 上传文件
     * @param file
     * @param downScore
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
     public String uplodFile(MultipartFile file, String downScore, HttpServletRequest request)throws IOException {
        String bookName = request.getParameter("bookName");
        String fileName = request.getParameter("fileName");
        String intro = request.getParameter("intro");
        if (!StringUtils.isEmpty(file) && null != bookName && null != downScore && null != fileName && null != intro && file.getSize() > 0) {
            String names = file.getOriginalFilename();//是得到上传时的文件名。
            String postfix = names.substring(names.lastIndexOf(".") + 1);
            User user = (User) request.getSession().getAttribute("user");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");//设置时间格式
            String restime = sdf.format(new Date());//操作时间
            Files files = new Files();
            files.setDocscore(Integer.parseInt(downScore));
            files.setDocname(bookName);
            files.setDocdes(intro);
            files.setDoctype(postfix);
            files.setUpdoctime(restime);
            files.setDocstatu("未审核");
            files.setDowcount(0);
            files.setUserid(user.getUserid());
            files.setDocurl("F:\\NDS\\" + names);
            List<DocType> dlist = userService.findDocType();
            List<String> slist = new ArrayList<>();
            for (int i =0;i<dlist.size();i++){
                String typename = dlist.get(i).getTypename();
                slist.add(typename);
            }
                if (slist.contains(postfix)) {
                    int flag = userService.UpLoadFiles(files);
                    if (flag > 0) {
                        file.transferTo(new File("F:\\NDS\\" + names));
                        return "{\"code\":0, \"msg\":\"\", \"data\":{}}";
                    }
                }
                return "{\"code\":1, \"msg\":\"\", \"data\":{}}";
            }
        return "{\"code\":2, \"msg\":\"\", \"data\":{}}";
    }

    /**
     * 下载文件
     * @param docid
     * @return
     * @throws IOException
     */
    @RequestMapping("/downFiles")
    public ResponseEntity<byte[]> downFiles(String docid) throws IOException{
        Files files = userService.findDowFiles(Integer.parseInt(docid));
        System.out.println(files.toString());
        File file = new File(files.getDocurl());
        HttpHeaders headers = new HttpHeaders();
        String fileName=new String(files.getDocname().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
    /**
     *管理员，用户文档查询
     * @param request
     * @param response
     */
    @RequestMapping("/findFiles")
    @ResponseBody
    public void findFiles(HttpServletRequest request, HttpServletResponse response){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String docname = request.getParameter("docname");
        String doctime1 = request.getParameter("doctime1");
        String endTime = request.getParameter("doctime2");
        int pageInt = Integer.valueOf(page);
        int limitInt = Integer.parseInt(limit);
        HashMap<String,Object> condition = new HashMap<>();
        if (null!=docname && !"".equals((docname.trim()))){
            condition.put("docname",docname);
        }else if (null!= doctime1 && !"".equals((doctime1.trim()))){
            condition.put("doctime1",doctime1);
        }if (null!= endTime && !"".equals((endTime.trim()))){
            condition.put("endTime",endTime);
        }
        int pageInts = (pageInt-1)*limitInt;
        condition.put("pageInts",pageInts);
        condition.put("limitInt",limitInt);
        Map map = userService.findFiles(condition);
        DatagridResult datagridResult = new DatagridResult();
        if (map.size() != 0){
            datagridResult.setCode(0);
            datagridResult.setMsg("");
            datagridResult.setCount((Integer) map.get("count"));
            datagridResult.setData((List<Files>) map.get("files"));
            ResponseUtils.outJson(response,datagridResult);
        }
    }

    /**
     * 文档管理
     * @param request
     * @param response
     */
    @RequestMapping("/findManagerFiles")
    @ResponseBody
    public void findManagerFiles(HttpServletRequest request, HttpServletResponse response){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String docname = request.getParameter("docname");
        String doctime1 = request.getParameter("doctime1");
        String endTime = request.getParameter("doctime2");
        String username = request.getParameter("username");
        String doctype = request.getParameter("doctype");
        int pageInt = Integer.valueOf(page);
        int limitInt = Integer.parseInt(limit);
        HashMap<String,Object> condition = new HashMap<>();
        if (null!=docname && !"".equals((docname.trim()))){
            condition.put("docname",docname);
        }else if (null!= doctime1 && !"".equals((doctime1.trim()))){
            condition.put("doctime1",doctime1);
        }
        if (null!= endTime && !"".equals((endTime.trim()))){
            condition.put("endTime",endTime);
        }if (null!=username && !"".equals((username.trim()))){
            User user = userService.findUser(username);
            String userid= String.valueOf(user.getUserid());
            condition.put("userid",userid);
        }if (null!=doctype && !"".equals((doctype.trim()))){
            condition.put("doctype",doctype);
        }
        int pageInts = (pageInt-1)*limitInt;
        condition.put("pageInts",pageInts);
        condition.put("limitInt",limitInt);
        Map map = userService.findManagerFiles(condition);
        DatagridResult datagridResult = new DatagridResult();
        if (map.size() != 0){
            datagridResult.setCode(0);
            datagridResult.setMsg("");
            datagridResult.setCount((Integer) map.get("count"));
            datagridResult.setData((List<Files>) map.get("files"));
            ResponseUtils.outJson(response,datagridResult);
        }
    }

    /**
     * 搜索文档
     * @param request
     * @param response
     */
    @RequestMapping("/findConFiles")
    @ResponseBody
    public void findConFiles(HttpServletRequest request, HttpServletResponse response){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String docname = request.getParameter("docname");
        int pageInt = Integer.valueOf(page);
        int limitInt = Integer.parseInt(limit);
        HashMap<String,Object> condition = new HashMap<>();
        if (null!=docname&&!"".equals((docname.trim()))){
            condition.put("docname",docname);
        }
        int pageInts = (pageInt-1)*limitInt;
        condition.put("pageInts",pageInts);
        condition.put("limitInt",limitInt);
        Map map = userService.findConFiles(condition);
        DatagridResult datagridResult = new DatagridResult();
        if (map.size() != 0){
            datagridResult.setCode(0);
            datagridResult.setMsg("");
            datagridResult.setCount((Integer) map.get("count"));
            datagridResult.setData((List<Files>) map.get("files"));
            ResponseUtils.outJson(response,datagridResult);
        }
    }

    /**
     * 搜索格式类型，返回页面
     * @param request
     * @return
     */
   @RequestMapping("/reUpload")
    public String reUpload(HttpServletRequest request){
        List<DocType> dlist = userService.findDocType();
        request.setAttribute("dlist",dlist);
        return "back/jsp/FilesManager";
    }
    @RequestMapping("/changeDocState")
    @ResponseBody
    public void changeDocState(HttpServletRequest request, HttpServletResponse response)throws IOException{
        Integer docid = Integer.valueOf(request.getParameter("docid"));
        String docstatu = request.getParameter("docstatu");
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("docid",docid);
        map.put("docstatu",docstatu);
        int flag = userService.changeDocState(map);
        if (flag>0){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }
    }

    /**
     * 查询用户
     * @param req
     * @param resp
     */
    @RequestMapping("/findDocTypes")
    @ResponseBody
    public void findDocTypes(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String typename = req.getParameter("typename");
        int pageInt = Integer.valueOf(page);
        int limitInt = Integer.parseInt(limit);
        HashMap<String,Object> condition = new HashMap<>();
        if (null!=typename&&!"".equals((typename.trim()))){
            condition.put("typename",typename);
        }
        int pageInts = (pageInt-1)*limitInt;
        condition.put("pageInts",pageInts);
        condition.put("limitInt",limitInt);
        Map map = userService.findTypes(condition);
        DatagridResult datagridResult = new DatagridResult();
        if (map.size() != 0){
            datagridResult.setCode(0);
            datagridResult.setMsg("");
            datagridResult.setCount((Integer) map.get("count"));
            datagridResult.setData((List<DocType>) map.get("docTypes"));
            ResponseUtils.outJson(resp,datagridResult);
        }
    }

    /**
     * 删除文件配置
     * @param req
     * @param resp
     * @throws IOException
     */
    @RequestMapping("/deleteTypes")
    public void deleteTypes(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        Integer typeid = Integer.valueOf(req.getParameter("typeid"));
        int flag = userService.deleteType(typeid);
        if (flag>0){
            resp.getWriter().print("success");
        }else{
            resp.getWriter().print("error");
        }
    }

    /**
     * 修改文件配置
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/updateType")
    public void updateTypes(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String typeInfo = request.getParameter("typeInfo");
        Gson gson = new Gson();
        DocType docType =  gson.fromJson(typeInfo,DocType.class);
        Integer typeid = Integer.valueOf(request.getParameter("typeid"));
        docType.setTypeid(typeid);
        Integer a = userService.updateType(docType);
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }
    }

    /**
     * 新增文件配置
     * @param request
     * @param response
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/addTypes")
    public void addTypes(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String typeInfo = request.getParameter("typeInfo");
        Gson gson = new Gson();
        DocType docType =  gson.fromJson(typeInfo,DocType.class);
        Integer a = userService.addType(docType);
        if (1==a){
            response.getWriter().print("success");
        }else{
            response.getWriter().print("error");
        }
    }


}
