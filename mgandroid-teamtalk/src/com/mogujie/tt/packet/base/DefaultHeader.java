package com.mogujie.tt.packet.base;

import com.mogujie.tt.config.SysConstant;
import com.mogujie.tt.log.Logger;
import com.mogujie.tt.utils.SequenceNumberMaker;

public class DefaultHeader extends Header {

	private Logger logger = Logger.getLogger(DefaultHeader.class);

	public DefaultHeader(int serviceId, int commandId) {
		setVersion((short) SysConstant.PROTOCOL_VERSION);
//		setFlag((short) SysConstant.PROTOCOL_FLAG);
		setServiceId(serviceId);
		setCommandId(commandId);
//		setError((short) SysConstant.PROTOCOL_ERROR);
		short seqNo = SequenceNumberMaker.getInstance().make();
		setReserved(seqNo);

		logger.d("packet#construct Default Header -> serviceId:%d, commandId:%d, seqNo:%d", serviceId, commandId, seqNo);
	}
}
