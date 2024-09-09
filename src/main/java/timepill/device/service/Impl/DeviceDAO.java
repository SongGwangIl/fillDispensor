package timepill.device.service.Impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import timepill.device.DeviceInfoVO;
import timepill.device.DeviceVO;

@Mapper
public interface DeviceDAO {
  
	String getuserDeviceId(String userId);

	List<String> getAlldeviceId();
	
	int deviceRegister(String deviceId, String userId);

	List<String> getdeviceId();

	int deviceRegister(DeviceVO vo);

	DeviceInfoVO getdeviceInfo(DeviceInfoVO dvo);

	int updateMydevice(DeviceInfoVO dvo);

	int deleteMydevice(DeviceInfoVO dvo);


}