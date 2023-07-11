1、本包为消息推送任务（目前实现了微信模版消息和短信）。
2、如果需要新增消息推送任务，新建类 extends AbstractNoticeTask<T> implements ITask即可。
    ps: T为消息内容泛型。
    可参考 ClassNoticeTask
3、任务设置同时开启模版消息和短消息的话，支持模版消息失败后尝试发送短消息。