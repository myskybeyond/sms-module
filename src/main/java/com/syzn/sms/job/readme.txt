系统定时任务实现类包
使用方法：
1、在impl包下新建类implements ITask接口,在run方法中写你的业务即可。

2、触发新建任务。admin登录web后台，找到系统任务管理菜单，新增按钮。bean名称写你新建的任务类名称（首字母小写），如有参数参数以json格式。cron表达式根据实际
情况填入。
example: bean名称:testTask 参数：{orgId:123,schoolId:456,allowSms:false,allowWpTemplateMsg:true},其中allowSms为false时可以不添加;allowWpTemplateMsg为true时可以不添加。
         allowSms:true-允许通过短信发送通知消息。默认关闭。
         allowWpTemplateMsg:true-允许通过微信公众号模版消息发送通知消息。默认开启。
tips：目前参数格式仅支持TaskParamBean类中的属性，后期需要可以扩充。


pay your attention:
1、springboot-devtool和quartzJob中的context.getMergedJobDataMap().get(JOB_PARAM_KEY)有冲突，如果项目有springboot-devtool包
    则会报 class A can not cast to Class A的错误。