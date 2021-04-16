import React, {Component} from 'react';
import {Descriptions} from "antd";

class ProductInfo extends Component {

  // state = {
  //   productInfo: null
  // }

  render() {
    const productInfo = this.props.info;
    return (
      <div>
        <Descriptions bordered style={{fontSize: '18px'}}>
          <Descriptions.Item label="Price:" span={3}> ${productInfo.price}</Descriptions.Item>
          <Descriptions.Item label="Post Date:" span={3}> {productInfo.postDate}</Descriptions.Item>
          <Descriptions.Item label="Descriptions:" span={3}> {productInfo.description}</Descriptions.Item></Descriptions>
      </div>
    );
  }
}

export default ProductInfo;
