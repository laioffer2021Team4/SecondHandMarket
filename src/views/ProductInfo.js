import React, {Component} from 'react';
import {Descriptions} from "antd";

class ProductInfo extends Component {

  state = {
    productInfo: null
  }

  componentDidMount() {
    // set productInfo form props
  }

  render() {
    return (
      <div>
        <Descriptions bordered style={{fontSize: '18px'}}>
          <Descriptions.Item label="Price:" span={3}> Price</Descriptions.Item>
          <Descriptions.Item label="Manufacture:" span={3}> Manufacture</Descriptions.Item>
          <Descriptions.Item label="Descriptions:" span={3} labelStyle={{position: 'absolute'}}>
            Please message me if you are interested :💌 ➡️ aryjessica4@ 🇬​ 🇲​ 🇦​ 🇮​ 🇱​ . 🇨​ 🇴​ 🇲 ⬅️💌
            I m Selling this Beautiful 2009 Mini cooper 3 Door , First owner. $800! Recent oil change done .The car passed all inspections made. Very clean on the inside and outside!!
          </Descriptions.Item>
        </Descriptions>
      </div>
    );
  }
}

export default ProductInfo;
